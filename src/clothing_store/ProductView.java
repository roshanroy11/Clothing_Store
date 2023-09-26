package clothing_store;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class ProductView extends JFrame {
    final private JComboBox<String> productType_Dropdown; // Encapsulation
    final private JComboBox<String> productName_Dropdown; // Encapsulation
    final private JComboBox<String> productColor_Dropdown; // Encapsulation
    final private JComboBox<String> productSize_Dropdown; // Encapsulation
    //final private JButton getProductButton; // Encapsulation
    final private JButton addProductButton; // Encapsulation
    final private JButton updateProductButton; // Encapsulation
    final private ProductModel model; // Abstraction


    // constructor for the GUI
    ProductView(ProductModel model){
        this.model = model;
        this.setSize(900, 900);

        Prod_Data Product_type = new Prod_Data();
        ArrayList<String> productType = Product_type.getProductType();
        productType.add(0,"Select Product Type");
        String[] pType = productType.toArray(new String[0]);
        productType_Dropdown = new JComboBox<>(pType);

        Prod_Data Product_name = new Prod_Data();
        ArrayList<String> productName = Product_name.getProductName();
        productName.add(0,"Select Product Name");
        String[] pName = productName.toArray(new String[0]);
        productName_Dropdown = new JComboBox<>(pName);

        Prod_Data Product_color = new Prod_Data();
        ArrayList<String> productColor = Product_color.getProductColor();
        productColor.add(0,"Select Product Color");
        String[] pColor = productColor.toArray(new String[0]);
        productColor_Dropdown = new JComboBox<>(pColor);

        Prod_Data Product_size = new Prod_Data();
        ArrayList<String> productSize = Product_size.getProductSize();
        productSize.add(0,"Select Product Size");
        String[] pSize = productSize.toArray(new String[0]);
        productSize_Dropdown = new JComboBox<>(pSize);

        //this.getProductButton = new JButton("Get Product by ID");
        this.addProductButton = new JButton("Check Out");
        this.updateProductButton = new JButton("Add to Cart");


        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Product Type: "));
        inputPanel.add(productType_Dropdown);
        inputPanel.add(new JLabel("Product Name: "));
        inputPanel.add(productName_Dropdown);
        inputPanel.add(new JLabel("Product Color: "));
        inputPanel.add(productColor_Dropdown);
        inputPanel.add(new JLabel("Product Size: "));
        inputPanel.add(productSize_Dropdown);

        inputPanel.setBackground(Color.PINK);


        JPanel productButtonPanel = new JPanel(new FlowLayout()); //  Creates Jpanel
//        productButtonPanel.add(getProductButton); // add Button to Jpanel
        productButtonPanel.add(addProductButton); // add Button to Jpanel
        productButtonPanel.add(updateProductButton); // add Button to Jpanel
        productButtonPanel.setBackground(Color.PINK); // add Button to Jpanel


        JPanel mainPanel = new JPanel(new BorderLayout()); // Border Layoput
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.setBackground(Color.PINK); // Background Color
        mainPanel.add(productButtonPanel, BorderLayout.SOUTH);

        this.setContentPane(mainPanel);
        this.pack();
        this.setTitle("Used Clothing Store");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ArrayList cartItems = new ArrayList<>(); // creates an Array lis that holds cartItems
                cartItems = (ShoppingCartData.readCartAllSQL()); // read items on database and stores in cartItems
                ShoppingCartWindow cartWindow = new ShoppingCartWindow(cartItems);
                cartWindow.setVisible(true); // set the ShoppingCart Window visible
            }
        });
        updateProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                // Show "Added to Cart" message
                JOptionPane.showMessageDialog(null, "Added to Cart");

                String selectedProductType = (String) productType_Dropdown.getSelectedItem();
                String selectedProductName = (String) productName_Dropdown.getSelectedItem();
                String selectedProductColor = (String) productColor_Dropdown.getSelectedItem();
                String selectedProductSize = (String) productSize_Dropdown.getSelectedItem();

                System.out.println("Selected Product Type: " + selectedProductType);
                System.out.println("Selected Product Name: " + selectedProductName);
                System.out.println("Selected Product Color: " + selectedProductColor);
                System.out.println("Selected Product Size: " + selectedProductSize);


            }
        });
    }
    // Action Listeners for Get Product by ID, Check Out, and Add to Cart
//    public void addProductButtonListener (ActionListener al){getProductButton.addActionListener(al);}
    public void addToCartButtonListener (ActionListener al){
        updateProductButton.addActionListener(al);}

//    public void createProductButtonListener (ActionListener al){
//        addProductButton.addActionListener(al);
//    }


    public void setCurrentProduct(Product newProduct){  // Sets the Value of the fields to display the values
        if(newProduct != null) {
            productType_Dropdown.setSelectedItem(newProduct.getProductType_Dropdown());
            productName_Dropdown.setSelectedItem(newProduct.getProductName_Dropdown());
            productColor_Dropdown.setSelectedItem(newProduct.getProductColor_Dropdown());
            productSize_Dropdown.setSelectedItem(newProduct.getProductSize_Dropdown());
        }
    }

    public Product addProductAction() { //Retrieves the values entered by the user and creates a new Product object
        String pType = (String) productType_Dropdown.getSelectedItem();
        String pName = (String) productName_Dropdown.getSelectedItem();
        String pColor = (String) productColor_Dropdown.getSelectedItem();
        String pSize = (String) productSize_Dropdown.getSelectedItem();

        return new Product(pType,pName,pColor,pSize);
    }



//    public int getProductAction() { //Retrieves the product ID entered by the user as an int or return -1
//        String text = productId.getText();
//        if (text.isEmpty()) {
//            return -1;
//        }
//        try {
//            return Integer.parseInt(text);
//        } catch (NumberFormatException e) {
//            return -1;
//        }
//    }

//    public Product addToCartProductAction() { //Retrieves the values entered by the user and creates a new Product object
//        String idString = productId.getText().trim();
//        if (idString.isEmpty()) {
//// Show an error message and return null or throw an exception
//            return null;
//        }
//        int id = Integer.parseInt(productId.getText());
//        String type = productType.getText();
//        String name = productName.getText();
//        String color = productColor.getText();
//        String size = productSize.getText();
//        String state = stateName.getText();
//        return new Product(id,type,name, color, size, state);
//    }
}
