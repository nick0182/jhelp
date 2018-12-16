package com.schaydulin.jhelp;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.schaydulin.jhelp.orm.Term;
import com.schaydulin.jhelp.repo.TermsRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.Optional;

@SpringBootApplication
public class MainFrame extends JFrame {

    private JPanel panel;
    private JTabbedPane tabbedPane;
    private JPanel menuPanel;
    private JMenuBar menuBar;
    private JPanel tabPanel;
    private JPanel mainTab;
    private JPanel settingsTab;
    private JPanel helpTab;
    private JPanel contentPanel;
    private JPanel buttonsPanel;
    private JButton findButton;
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;
    private JButton nextButton;
    private JButton previousButton;
    private JTextField textField1;
    private JPanel termPanel;
    private JPanel textPanel;
    private JTextArea textArea1;
    private JButton exitButton;
    private JMenu fileMenu;
    private JMenu editMenu;
    private JMenu settingsMenu;
    private JMenu helpMenu;

    MainFrame(TermsRepository termsRepository) {

        super("JHelp Client");

        $$$setupUI$$$();
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(800, 600);
        setResizable(false);
        setVisible(true);

        findButton.addActionListener(e -> {

            Optional<Term> anInstanceof = termsRepository.findByTerm("instanceof");

            anInstanceof.ifPresent(of -> System.err.println(of.getDefinitions()));


        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        settingsMenu = new JMenu("Settings");
        helpMenu = new JMenu("Help");

        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(settingsMenu);
        menuBar.add(helpMenu);

    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(MainFrame.class, args);

        SwingUtilities.invokeLater(() -> context.getBean(MainFrame.class));

    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));
        menuPanel = new JPanel();
        menuPanel.setLayout(new BorderLayout(0, 0));
        panel.add(menuPanel, BorderLayout.NORTH);
        menuPanel.add(menuBar, BorderLayout.NORTH);
        tabPanel = new JPanel();
        tabPanel.setLayout(new BorderLayout(0, 0));
        panel.add(tabPanel, BorderLayout.CENTER);
        tabbedPane = new JTabbedPane();
        tabPanel.add(tabbedPane, BorderLayout.CENTER);
        mainTab = new JPanel();
        mainTab.setLayout(new BorderLayout(15, 0));
        tabbedPane.addTab("Main", mainTab);
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(0, 0));
        mainTab.add(contentPanel, BorderLayout.CENTER);
        termPanel = new JPanel();
        termPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 5, 10, 10), 0, 0));
        contentPanel.add(termPanel, BorderLayout.NORTH);
        final JLabel label1 = new JLabel();
        label1.setText("Term:");
        termPanel.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        termPanel.add(textField1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, 30), null, 0, false));
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPanel.add(textPanel, BorderLayout.CENTER);
        final JLabel label2 = new JLabel();
        label2.setText("Definitions:");
        textPanel.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea1 = new JTextArea();
        textPanel.add(textArea1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayoutManager(10, 2, new Insets(0, 0, 0, 0), -1, -1));
        mainTab.add(buttonsPanel, BorderLayout.EAST);
        findButton = new JButton();
        findButton.setText("Find");
        buttonsPanel.add(findButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(58, 30), null, 0, false));
        addButton = new JButton();
        addButton.setText("Add");
        buttonsPanel.add(addButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(58, 30), null, 0, false));
        editButton = new JButton();
        editButton.setText("Edit");
        buttonsPanel.add(editButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(58, 30), null, 0, false));
        deleteButton = new JButton();
        deleteButton.setText("Delete");
        buttonsPanel.add(deleteButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(58, 30), null, 0, false));
        nextButton = new JButton();
        nextButton.setText("Next");
        buttonsPanel.add(nextButton, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(58, 30), null, 0, false));
        previousButton = new JButton();
        previousButton.setText("Previous");
        buttonsPanel.add(previousButton, new GridConstraints(7, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(58, 30), null, 0, false));
        final Spacer spacer1 = new Spacer();
        buttonsPanel.add(spacer1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(58, 14), null, 0, false));
        final Spacer spacer2 = new Spacer();
        buttonsPanel.add(spacer2, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(58, 14), null, 0, false));
        final Spacer spacer3 = new Spacer();
        buttonsPanel.add(spacer3, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        buttonsPanel.add(spacer4, new GridConstraints(8, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(58, 14), null, 0, false));
        exitButton = new JButton();
        exitButton.setText("Exit");
        buttonsPanel.add(exitButton, new GridConstraints(9, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        settingsTab = new JPanel();
        settingsTab.setLayout(new BorderLayout(0, 0));
        tabbedPane.addTab("Settings", settingsTab);
        helpTab = new JPanel();
        helpTab.setLayout(new BorderLayout(0, 0));
        tabbedPane.addTab("Help", helpTab);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel;
    }

}
