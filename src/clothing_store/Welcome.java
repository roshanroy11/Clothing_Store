package clothing_store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Welcome extends JFrame {
    final private JButton loginCustomerButton;
    final private JButton signUpCustomerButton;

    public Welcome() {
        super("Used Clothing Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(900, 200);

        this.loginCustomerButton = new JButton("Login");
        loginCustomerButton.setSize(450,100);
        this.signUpCustomerButton = new JButton("Signup");
        signUpCustomerButton.setSize(450,100);
        JLabel welcomeLabel = new JLabel("Welcome to Used Clothing Store");
        welcomeLabel.setFont(welcomeLabel.getFont().deriveFont(45f)); // set the font size to 24
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setBackground(Color.PINK);



        JPanel loginAndSignupCustomerPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        loginAndSignupCustomerPanel.add(loginCustomerButton);
        loginAndSignupCustomerPanel.add(signUpCustomerButton);
        loginAndSignupCustomerPanel.setBackground(Color.PINK);


        getContentPane().setLayout(new BorderLayout(10, 10));
        getContentPane().setBackground(Color.PINK);
        getContentPane().add(welcomeLabel, BorderLayout.NORTH);
        getContentPane().add(loginAndSignupCustomerPanel, BorderLayout.SOUTH);

        loginCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginModel model = new LoginModel();
                LoginView loginView = new LoginView(model);
                LoginController controller = new LoginController(model, loginView);
                loginView.setVisible(true);
            }
        });

        signUpCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SignUpModel model = new SignUpModel();
                SignUpView view = new SignUpView(model);
                SignUpController controller = new SignUpController(model, view);
                view.setVisible(true);
            }
        });

    }
}
