package com.schaydulin.jhelp;

import com.schaydulin.jhelp.orm.Definition;
import com.schaydulin.jhelp.orm.Term;
import com.schaydulin.jhelp.repo.TermsRepository;
import command.Command;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

@SpringBootApplication
public class Main {

    private TermsRepository termsRepository;

    private static final int PORT = 16105;

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

    public Main(TermsRepository termsRepository) {

        this.termsRepository = termsRepository;

        try (ServerSocket serverSocket = new ServerSocket(PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            ExecutorService executorService = Executors.newSingleThreadExecutor();

            executorService.submit(new Server(serverSocket));

            executorService.shutdown();

            System.out.printf("Local server is launched on port: %d\n", PORT);

            System.out.println("To shutdown type \"exit\"");

            String line;

            while ((line = reader.readLine()) != null)
                if (line.equals("exit")) {
                    serverSocket.close();
                    break;
                }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    private class Server implements Runnable {

        private ServerSocket serverSocket;

        Server(ServerSocket serverSocket) {

            this.serverSocket = serverSocket;

        }

        @Override
        public void run() {

            ExecutorService es = Executors.newCachedThreadPool();

            try {
                while (true) {
                    Socket clientSocket = serverSocket.accept();
                    es.submit(new ClientWorker(clientSocket));
                }
            } catch (IOException e) {
                es.shutdown();
            } finally {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    private class ClientWorker implements Runnable {

        private Socket clientSocket;

        ClientWorker(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {

            try (ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
                 ObjectOutputStream ous = new ObjectOutputStream(clientSocket.getOutputStream())) {

                Command command = (Command) ois.readObject();

                switch (command) {

                    case FIND:
                        find(ois, ous);
                        break;
                    case ADD:
                        add(ois);
                        break;
                    case DELETE_TERM:
                        deleteTerm(ois, ous);
                        break;

                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }

        private void find(ObjectInputStream ois, ObjectOutputStream ous) throws IOException, ClassNotFoundException {

            String term = (String) ois.readObject();

            Optional<Term> found = termsRepository.findByTerm(term);

            if (found.isPresent()) {
                List<Definition> definitions = found.get().getDefinitions();
                for (Definition def : definitions)
                    ous.writeObject(def.toString());
            } else
                ous.writeObject(null);

        }

        private void add(ObjectInputStream ois) throws IOException, ClassNotFoundException {

            String term = (String) ois.readObject();

            String definition = (String) ois.readObject();

            Optional<Term> found = termsRepository.findByTerm(term);

            if (found.isPresent()) {

                Term foundTerm = found.get();

                foundTerm.addDefinition(new Definition(definition));

                termsRepository.saveAndFlush(foundTerm);

            } else {

                Term newTerm = new Term(term);

                newTerm.addDefinition(new Definition(definition));

                termsRepository.saveAndFlush(newTerm);

            }

        }

        private void deleteTerm(ObjectInputStream ois, ObjectOutputStream ous) throws IOException, ClassNotFoundException {

            String term = (String) ois.readObject();

            Optional<Term> found = termsRepository.findByTerm(term);

            found.ifPresent(term1 -> termsRepository.delete(term1));

        }

    }

}
