package clothing_store;

public class SignUpModel {
    public SignUpModel(){}
    public Customer addCustomer(Customer cus){
        return Cust_Data.createCustomerSQL(cus);
    }
}
