package clothing_store;

public class LoginModel {
    public LoginModel(){}
    public Customer getCustomer(int id){
        Cust_Data customer = new Cust_Data();
        return customer.readByCustomerIdSQL(id);
    }
//    public Customer loginCustomer(Customer cus){
//        return Cust_Data.createCustomerSQL(cus);
//    }

}
