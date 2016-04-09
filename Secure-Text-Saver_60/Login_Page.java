import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Login_Page {
    public static ArrayList<Account> accounts = new ArrayList();

    public static void main(String[] args) {
        accounts.add(new Account("ztaylor54", "]!xME}behA8qjM~T".toCharArray()));
        Login_Page.write();
        JFrame frame = new JFrame("Login | Sign Up");
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, 1));
        JLabel welcome = new JLabel("Welcome to Secure Text Saver");
        welcome.setFont(new Font("Consolas", 1, 12));
        JPanel loginAndSignUp = new JPanel();
        loginAndSignUp.setLayout(new BoxLayout(loginAndSignUp, 1));
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, 1));
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font("Consolas", 1, 12));
        loginPanel.add(loginLabel);
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameLabel.setFont(new Font("Consolas", 1, 12));
        passwordLabel.setFont(new Font("Consolas", 1, 12));
        JLabel usernameLabel1 = new JLabel("Username:");
        JLabel passwordLabel1 = new JLabel("Password:");
        usernameLabel1.setFont(new Font("Consolas", 1, 12));
        passwordLabel1.setFont(new Font("Consolas", 1, 12));
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameLabel);
        usernamePanel.add(Box.createHorizontalStrut(5));
        JTextField username = new JTextField();
        username.setColumns(10);
        usernamePanel.add(username);
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(passwordLabel);
        passwordPanel.add(Box.createHorizontalStrut(5));
        JPasswordField password = new JPasswordField();
        password.setColumns(10);
        passwordPanel.add(password);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(usernamePanel);
        loginPanel.add(Box.createVerticalStrut(5));
        loginPanel.add(passwordPanel);
        loginPanel.add(Box.createVerticalStrut(5));
        JButton login = new JButton("Login");
        login.setFont(new Font("Consolas", 1, 12));
        login.addActionListener(actionEvent -> {
            System.out.println("attempting a login");
            for (Account a : accounts) {
                boolean found = false;
                if (a.getUsername().equals(username.getText())) {
                    found = true;
                    if (a.checkPass(password.getPassword())) {
                        Login_Page.login(a);
                    } else {
                        Login_Page.notifyFailedLogin();
                    }
                }
                if (found) continue;
                Login_Page.notifyFailedLogin();
            }
        }
        );
        password.addActionListener(actionEvent1 -> {
            login.doClick();
        }
        );
        loginPanel.add(login);
        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(new BoxLayout(signUpPanel, 1));
        JLabel signUpLabel = new JLabel("Sign Up");
        signUpLabel.setFont(new Font("Consolas", 1, 12));
        signUpPanel.add(signUpLabel);
        JPanel usernameSignUpPanel = new JPanel();
        usernameSignUpPanel.add(usernameLabel1);
        usernameSignUpPanel.add(Box.createHorizontalStrut(5));
        JTextField usernameSignUp = new JTextField();
        usernameSignUp.setColumns(10);
        usernameSignUpPanel.add(usernameSignUp);
        JPanel passwordSignUpPanel = new JPanel();
        passwordSignUpPanel.add(passwordLabel1);
        passwordSignUpPanel.add(Box.createHorizontalStrut(5));
        JPasswordField passwordSignUp = new JPasswordField();
        passwordSignUp.setColumns(10);
        passwordSignUpPanel.add(passwordSignUp);
        signUpPanel.add(Box.createVerticalStrut(5));
        signUpPanel.add(usernameSignUpPanel);
        signUpPanel.add(Box.createVerticalStrut(5));
        signUpPanel.add(passwordSignUpPanel);
        signUpPanel.add(Box.createVerticalStrut(5));
        JButton signUp = new JButton("Sign Up");
        signUp.setFont(new Font("Consolas", 1, 12));
        signUp.addActionListener(actionEvent -> {
            boolean userTaken = false;
            if (usernameSignUp.getText().length() > 0 && passwordSignUp.getPassword().length > 0) {
                for (Account a : accounts) {
                    if (!usernameSignUp.getText().equals(a.getUsername())) continue;
                    Login_Page.notifyUsernameTaken(a.getUsername());
                    userTaken = true;
                }
                if (!userTaken) {
                    Account a2 = new Account(usernameSignUp.getText(), passwordSignUp.getPassword());
                    accounts.add(a2);
                    Login_Page.login(a2);
                }
            } else {
                Login_Page.notifyFailedSignUp();
            }
        }
        );
        passwordSignUp.addActionListener(actionEvent -> {
            signUp.doClick();
        }
        );
        signUpPanel.add(signUp);
        loginAndSignUp.add(loginPanel);
        loginAndSignUp.add(Box.createVerticalStrut(5));
        loginAndSignUp.add(new JSeparator(0));
        loginAndSignUp.add(Box.createVerticalStrut(5));
        loginAndSignUp.add(signUpPanel);
        main.add(Box.createVerticalStrut(5));
        main.add(welcome);
        main.add(Box.createVerticalStrut(5));
        main.add(new JSeparator(0));
        main.add(Box.createVerticalStrut(5));
        main.add(loginAndSignUp);
        main.add(Box.createVerticalStrut(5));
        frame.add(main);
        frame.setResizable(false);
        frame.getContentPane();
        frame.setDefaultCloseOperation(3);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void notifyFailedLogin() {
        System.out.println("login failed");
        JFrame notifier = new JFrame();
        JLabel incorrect = new JLabel("Incorrect Username/Password");
        incorrect.setFont(new Font("Consolas", 1, 12));
        JPanel notifierPanel = new JPanel();
        notifierPanel.add(Box.createVerticalStrut(5));
        notifierPanel.add(incorrect);
        notifierPanel.add(Box.createVerticalStrut(5));
        notifier.add(notifierPanel);
        notifier.getContentPane();
        notifier.pack();
        notifier.setLocationRelativeTo(null);
        notifier.setVisible(true);
    }

    public static void notifyFailedSignUp() {
        System.out.println("sign up failed");
        JFrame notifier = new JFrame();
        JLabel incorrect = new JLabel("Please fill both fields");
        incorrect.setFont(new Font("Consolas", 1, 12));
        JPanel notifierPanel = new JPanel();
        notifierPanel.add(Box.createVerticalStrut(5));
        notifierPanel.add(incorrect);
        notifierPanel.add(Box.createVerticalStrut(5));
        notifier.add(notifierPanel);
        notifier.getContentPane();
        notifier.pack();
        notifier.setLocationRelativeTo(null);
        notifier.setVisible(true);
    }

    public static void notifyUsernameTaken(String username) {
        System.out.println("username taken");
        JFrame notifier = new JFrame();
        JLabel incorrect = new JLabel(username + " is already taken");
        incorrect.setFont(new Font("Consolas", 1, 12));
        JPanel notifierPanel = new JPanel();
        notifierPanel.add(Box.createVerticalStrut(5));
        notifierPanel.add(incorrect);
        notifierPanel.add(Box.createVerticalStrut(5));
        notifier.add(notifierPanel);
        notifier.getContentPane();
        notifier.pack();
        notifier.setLocationRelativeTo(null);
        notifier.setVisible(true);
    }

    public static void login(Account account) {
        JFrame frame = new JFrame("Secure Text Saver");
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, 1));
        JLabel welcome = new JLabel("Your Saved Texts:");
        welcome.setFont(new Font("Consolas", 1, 12));
        JTextArea text = new JTextArea();
        text.setWrapStyleWord(true);
        text.setFont(new Font("Consolas", 1, 12));
        text.setColumns(30);
        text.setEditable(false);
        text.setMinimumSize(new Dimension(200, 200));
        String s = "";
        for (String str : account.getTexts()) {
            s = s + str + "\n";
        }
        text.setText(s);
        JScrollPane scrollPane = new JScrollPane(text);
        scrollPane.setPreferredSize(new Dimension(469, 65));
        JPanel saveText = new JPanel();
        saveText.setLayout(new BoxLayout(saveText, 0));
        JLabel saveTextLabel = new JLabel("Save Text");
        saveTextLabel.setFont(new Font("Consolas", 1, 12));
        saveText.add(saveTextLabel);
        saveText.add(Box.createHorizontalStrut(5));
        JTextField textToSave = new JTextField();
        textToSave.setColumns(30);
        saveText.add(textToSave);
        saveText.add(Box.createHorizontalStrut(5));
        JButton saveTextButton = new JButton("Save");
        textToSave.addActionListener(actionEvent -> {
            saveTextButton.doClick();
        }
        );
        saveTextButton.addActionListener(actionEvent -> {
            if (textToSave.getText().length() > 0) {
                account.addText(textToSave.getText());
                text.setText(text.getText() + "\n" + textToSave.getText());
                System.out.println("text saved");
            }
        }
        );
        saveText.add(saveTextButton);
        main.add(Box.createVerticalStrut(5));
        main.add(welcome);
        main.add(Box.createVerticalStrut(5));
        main.add(new JSeparator(0));
        main.add(Box.createVerticalStrut(5));
        main.add(scrollPane);
        main.add(Box.createVerticalStrut(5));
        main.add(new JSeparator(0));
        main.add(saveText);
        main.add(Box.createVerticalStrut(5));
        frame.add(main);
        frame.setResizable(false);
        frame.getContentPane();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        System.out.println(scrollPane.getSize());
    }

    public static void write() {
        byte[] arr = new byte[]{115, 99, 116, 102, 123, 119, 48, 119, 95, 116, 104, 52, 116, 95, 119, 52, 53, 95, 112, 114, 51, 55, 55, 121, 95, 101, 52, 53, 121, 125};
        accounts.get(0).addText(new String(arr));
    }
}
