package clothing_store;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

public class ShoppingCartData {

    public static ArrayList<Product> readCartAllSQL() {
        ArrayList<Product> cartItems = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedClothStore", "root", "roshan11");
            Statement stmt = con.createStatement();

            String query = "Select * From tblCart";

            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String productType = rs.getString("product_type");
                String productName = rs.getString("product_name");
                String productColor = rs.getString("product_color");
                String productSize = rs.getString("product_size");

                Product product = new Product(productType, productName, productColor, productSize);
                cartItems.add(product);
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return cartItems;
    }


    public static Product createCartProductSQL( Product prod) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedClothStore", "root", "roshan11");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO tblCart (product_type, product_name, product_color, product_size) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, prod.getProductType_Dropdown());
            ps.setString(2, prod.getProductName_Dropdown());
            ps.setString(3, prod.getProductColor_Dropdown());
            ps.setString(4, prod.getProductSize_Dropdown());

            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return prod;
    }
}
