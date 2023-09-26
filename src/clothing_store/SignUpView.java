package clothing_store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class SignUpView extends JFrame {
    final private JTextField first_Name;
    final private JTextField last_Name;
    final private JTextField Email;
    final private JTextField phone_Number;

    final private JComboBox<String> stateDropdown;

    final private JButton signUpButton;
    //    final private JButton updateLogin;
    final private SignUpModel model;

    // constructor for the GUI
    SignUpView(SignUpModel model){
        this.model = model;
        this.setSize(900, 900);
        this.first_Name = new JTextField(15);
        this.last_Name = new JTextField(15);
        this.Email = new JTextField(15);
        this.phone_Number= new JTextField(10);

        this.signUpButton = new JButton("Sign Up");

        Cust_Data stateName = new Cust_Data();
        ArrayList<String> stateCodes = stateName.getState();
        stateCodes.add(0, "Select State");
        String[] states = stateCodes.toArray(new String[0]);
        stateDropdown = new JComboBox<>(states);


        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("First Name: "));
        inputPanel.add(first_Name);
        inputPanel.add(new JLabel("Last Name: "));
        inputPanel.add(last_Name);
        inputPanel.add(new JLabel("Email: "));
        inputPanel.add(Email);
        inputPanel.add(new JLabel("Phone Number: "));
        inputPanel.add(phone_Number);

        inputPanel.add(new JLabel("State: "));
        inputPanel.add(stateDropdown);
        inputPanel.add(signUpButton);

        inputPanel.setBackground(Color.PINK);


        JPanel goShopPanel = new JPanel(new FlowLayout());
        goShopPanel.add(signUpButton);
        goShopPanel.setBackground(Color.PINK);



        JPanel southPanel = new JPanel(new GridLayout(1, 2));
        southPanel.add(goShopPanel);
        southPanel.setBackground(Color.PINK);


        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.setBackground(Color.PINK);
        mainPanel.add(southPanel, BorderLayout.SOUTH);;


        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Used Clothing Store");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

                LoginModel model = new LoginModel();
                LoginView loginView = new LoginView(model);
                LoginController controller = new LoginController(model, loginView);
                loginView.setVisible(true);
            }

        });
    }


    public void createCustomerButtonListener (ActionListener al){
        signUpButton.addActionListener(al);
    }

    public void setCurrentCustomer(Customer newCustomer){
        if(newCustomer != null) {
            first_Name.setText(newCustomer.getFirstName());
            last_Name.setText(newCustomer.getLastName());
            Email.setText(newCustomer.getEmail());
            phone_Number.setText(newCustomer.getPhoneNumber());
        }
    }
    //    public int getCustomerAction(){return Integer.parseInt(customer_ID.getText());}
    public Customer addCustomerAction() {
        String f_name = first_Name.getText();
        String l_name = last_Name.getText();
        String email = Email.getText();
        String p_number = phone_Number.getText();
        String state = (String) stateDropdown.getSelectedItem();
        return new Customer(f_name, l_name, email, p_number, state);
    }
}
