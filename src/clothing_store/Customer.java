package clothing_store;

public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String payment;
    private String state;

//    public Customer(int id, String firstName, String lastName, String email, String phoneNumber, String payment) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.payment = payment;
//    }
    public Customer(int id, String firstName, String lastName, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;

    }
    public Customer(String firstName, String lastName, String email, String phoneNumber, String state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.state = state;
    }

    // Get & Set Customer ID
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    // Get & Set First name
    public String getFirstName() {
        return firstName;
    }
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }

    // Get & Set Last Name
    public String getLastName() {
        return lastName;
    }
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }

    // Get & Set Email
    public String getEmail() {
        return email;
    }
//    public void setEmail(String email) {
//        this.email = email;
//    }

    // Get Phone Number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Set Phone Number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Get & Set State
    public String getState() {return state;}
    public void setState(String state) {this.state = state;}


    // Get Payment
    public String getPayment() {
        return payment;
    }

    // Set Payment
    public void setPayment(String payment) {
        this.payment = payment;
    }
}
