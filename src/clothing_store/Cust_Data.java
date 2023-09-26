package clothing_store;

import java.sql.*;
import java.util.*;
public class Cust_Data {
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


    public ArrayList<String> getState() {
        ArrayList<String> stateCodes = new ArrayList<>();
        try {
            ResultSet rs = get_connection().executeQuery("Select state_code from State");
            while (rs.next()){
                String stateCode = rs.getString("state_code");
                stateCodes.add(stateCode);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return stateCodes;
    }




    // Read by ID
    public Customer readByCustomerIdSQL(int id){
        Customer cus = null;
        try {
            ResultSet rs = get_connection().executeQuery("SELECT * FROM Customer WHERE CustomerId=" + id);

            while (rs.next()) {
                cus = new Customer(rs.getInt("CustomerId"),rs.getString("first_Name"), rs.getString("last_Name"),
                        rs.getString("Email"), rs.getString("phone_Number"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return cus;
    }

    public static Integer getStateID(String state) {
        Integer sId = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedClothStore", "root", "roshan11");
            String query = "SELECT state_id FROM State WHERE state_code = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, state);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                sId = rs.getInt("state_id");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return sId;
    }

    public String getStateCodeByStateID(int stateId) {
        String stateCode = null;
        try {
            ResultSet rs = get_connection().executeQuery("SELECT state_code FROM State WHERE state_id = " + stateId);

            while (rs.next()) {
                stateCode = rs.getString("state_code");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return stateCode;
    }

    public static Customer createCustomerSQL(Customer cus){

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/UsedClothStore", "root", "roshan11");
            Statement stmt = con.createStatement();
            String query = "INSERT INTO Customer (first_Name, last_Name, Email, phone_Number, state_id) " +
                    "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cus.getFirstName());
            ps.setString(2, cus.getLastName());
            ps.setString(3, cus.getEmail());
            ps.setString(4, cus.getPhoneNumber());
            ps.setInt(5, getStateID(cus.getState()));

            ps.executeUpdate();
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                cus.setId(generatedKeys.getInt(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return cus;
    }

    // Read ALL SQL
    //    public void readAllSQL() {
//        ArrayList<Customer> cust = new ArrayList<Customer>();
//        try {
//            ResultSet rs = get_connection().executeQuery("select * from Customer");
//
//            while (rs.next()) {
//                Customer cus = new Customer(rs.getInt("CustomerId"),rs.getString("first_Name"), rs.getString("last_Name"),
//                        rs.getString("Email"), rs.getString("phone_Number"));
//
//                cust.add(cus);
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

}
