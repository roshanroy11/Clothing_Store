package clothing_store;
import java.sql.*;
import java.util.*;
public class Prod_Data {
    public static Statement get_connection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedClothStore", "root", "roshan11");
            Statement stmt = con.createStatement();
            return stmt;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public ArrayList<String> getProductType() {
        ArrayList<String> productType = new ArrayList<>();
        try {
            ResultSet rs = get_connection().executeQuery("Select DISTINCT product_type from Product");
            while (rs.next()){
                String product_Type = rs.getString("product_type");
                productType.add(product_Type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productType;
    }

    public ArrayList<String> getProductName() {
        ArrayList<String> productName = new ArrayList<>();
        try {
            ResultSet rs = get_connection().executeQuery("Select DISTINCT product_name from Product");
            while (rs.next()){
                String product_Name = rs.getString("product_name");
                productName.add(product_Name);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productName;
    }

    public ArrayList<String> getProductColor() {
        ArrayList<String> productColor = new ArrayList<>();
        try {
            ResultSet rs = get_connection().executeQuery("Select DISTINCT product_color from Product");
            while (rs.next()){
                String product_Color = rs.getString("product_color");
                productColor.add(product_Color);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productColor;
    }

    public ArrayList<String> getProductSize() {
        ArrayList<String> productSize = new ArrayList<>();
        try {
            ResultSet rs = get_connection().executeQuery("Select DISTINCT product_size from Product");
            while (rs.next()){
                String product_Size = rs.getString("product_size");
                productSize.add(product_Size);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return productSize;
    }






    public static Product createProductSQL( Product prod) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedClothStore", "root", "roshan11");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Product (product_type, product_name, product_color, product_size) " +
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



    //    public void readAllProducts(){
//        readAllSQL();
//    }

    // Read All SQL
//    public static ArrayList<Product> readAllSQL() {
//        ArrayList<Product> product = new ArrayList<Product>();
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedCloth_ST", "root", "roshan11");
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT * FROM Product");
//
//            while (rs.next()) {
//                Product prod = new Product(rs.getInt("Product_Id"),rs.getString("Product_Type"), rs.getString("Product_Name"),
//                        rs.getString("Product_Color"), rs.getString("Product_Size"), rs.getString("State_Name"));
//
//                product.add(prod);
//            }
//
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        return product;
//    }




//    public static Product updateProductSQL(Product prod) {
//        try {
//// Here, "Bike Store" is the database name, "root" is the username and "password" is the password
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedCloth_ST", "root", "roshan11");
//            Statement stmt = con.createStatement();
//            String query = "UPDATE Product SET Product_Type = ?, Product_Name = ?, Product_Color = ?, " +
//                    "Product_Size = ?, State_Name = ? WHERE Product_Id = ?";
//            PreparedStatement ps = con.prepareStatement(query);
//            ps.setString(1, prod.getProductType());
//            ps.setString(2, prod.getProductName());
//            ps.setString(3, prod.getProductColor());
//            ps.setString(4, prod.getProductSize());
//            ps.setString(5, prod.getStateName());
//            ps.setInt(6, prod.getProductID());
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return prod;
//    }
//
//    private static void deleteSql(int id){
//        try {
//// Here, "Bike Store" is the database name, "root" is the username and "password" is the password
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedCloth-ST", "root", "roshan11");
//            PreparedStatement ps = con.prepareStatement("DELETE FROM products WHERE id = ?");
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }
}
