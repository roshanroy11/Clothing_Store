package clothing_store;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShoppingCartWindow extends JFrame {

    public ShoppingCartWindow(ArrayList<Product> cartItems) {


        setTitle("Shopping Cart");
        this.setBackground(Color.PINK);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

// Create the table model
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Item_No.");
        model.addColumn("Type");
        model.addColumn("Name");
        model.addColumn("Color");
        model.addColumn("Size");


// Add data to the table model
        ArrayList<Product> theCart = cartItems != null ? cartItems : ShoppingCartData.readCartAllSQL();
        int rowNum =1;
        for (Product item : theCart) {
            model.addRow(new Object[] { rowNum ++, item.getProductType_Dropdown(), item.getProductName_Dropdown(), item.getProductColor_Dropdown(), item.getProductSize_Dropdown(), item.getState() });
        }


// Create the JTable with the table model
        JTable table = new JTable(model);


// Add the table to the scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBackground(Color.PINK);

// Create the checkout button
        JButton checkoutButton = new JButton("Checkout");
        checkoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
//                ShippingModel model = new ShippingModel();
//                ShippingView view = new ShippingView(model);
//                ShippingController controller = new ShippingController(model,view);
//                view.setVisible(true);
            }
        });

// Add the scroll pane and checkout button to the panel
        JPanel cartPanel = new JPanel(new BorderLayout());
        cartPanel.add(scrollPane, BorderLayout.CENTER);
        cartPanel.add(checkoutButton, BorderLayout.SOUTH);
        cartPanel.setBackground(Color.PINK);

// Add the panel to the frame
        add(cartPanel);

        setSize(800, 600);
        setVisible(true);
    }
}
