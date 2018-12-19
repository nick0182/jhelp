package com.schaydulin.jhelp;

import com.schaydulin.jhelp.repo.TermsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

    }

    public Main(TermsRepository termsRepository) {



    }

}
