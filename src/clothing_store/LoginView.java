package clothing_store;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginView extends JFrame {

    final private JTextField customer_ID;
    final private JTextField first_Name;
    final private JTextField last_Name;
    final private JTextField Email;
    final private JTextField phone_Number;
    final private JButton loginCustomerButton;
    final private JButton getCustomerButton;
    final private LoginModel model;

    LoginView(LoginModel model) {
        this.model = model;
        this.setSize(900, 900);
        this.customer_ID = new JTextField(20);
        this.first_Name = new JTextField(15);
        this.last_Name = new JTextField(15);
        this.Email = new JTextField(15);
        this.phone_Number = new JTextField(10);
        this.getCustomerButton = new JButton("Get Customer Info by ID");
        this.loginCustomerButton = new JButton("Login");

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Customer ID: "));
        inputPanel.add(customer_ID);
        inputPanel.add(new JLabel("First Name: "));
        inputPanel.add(first_Name);
        inputPanel.add(new JLabel("Last Name: "));
        inputPanel.add(last_Name);
        inputPanel.add(new JLabel("Email: "));
        inputPanel.add(Email);
        inputPanel.add(new JLabel("Phone Number: "));
        inputPanel.add(phone_Number);
        inputPanel.setBackground(Color.PINK);

        JPanel loginCustomerPanel = new JPanel(new FlowLayout());
        loginCustomerPanel.add(loginCustomerButton);
        loginCustomerPanel.setBackground(Color.PINK);
        JPanel getCustomerPanel = new JPanel(new FlowLayout());
        getCustomerPanel.add(getCustomerButton);
        getCustomerPanel.setBackground(Color.PINK);

        JPanel southPanel = new JPanel(new GridLayout(1, 2));
        southPanel.add(getCustomerPanel);
        southPanel.add(loginCustomerPanel);
        southPanel.setBackground(Color.PINK);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.setBackground(Color.PINK);
        mainPanel.add(southPanel, BorderLayout.SOUTH);

        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Used Clothing Store");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
//                ProductModel model = new ProductModel();
//                ProductView view = new ProductView(model);
//                ProductController controller = new ProductController(model, view);
//                view.setVisible(true);
            }
        });
    }

    public void setCurrentCustomer(Customer newCustomer) {
        if (newCustomer != null) {
            first_Name.setText(newCustomer.getFirstName());
            last_Name.setText(newCustomer.getLastName());
            Email.setText(newCustomer.getEmail());
            phone_Number.setText(newCustomer.getPhoneNumber());
        }
    }

    public void getCustomerButtonListener (ActionListener al){
        getCustomerButton.addActionListener(al);
    }

    public void getloginButtonListener(ActionListener al) {
        loginCustomerButton.addActionListener(al);
    }


//    public void getCustomerButtonListener (ActionListener al){
//        getCustomerButton.addActionListener(al);
//    }

    public int getCustomerAction(){return Integer.parseInt(customer_ID.getText());}

    public Customer loginCustomerAction() {
        int cus_id = Integer.parseInt(customer_ID.getText());
        String f_name = first_Name.getText();
        String l_name = last_Name.getText();
        String email = Email.getText();
        String p_number = phone_Number.getText();
        return new Customer(cus_id, f_name, l_name, email, p_number);
    }
}
