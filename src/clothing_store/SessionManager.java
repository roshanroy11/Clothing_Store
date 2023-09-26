package clothing_store;

public class SessionManager {
    private static int loggedInCustomerId = -1; // Default value indicates no user is logged in

    // Method to set the loggedInCustomerId
    public static void setLoggedInCustomerId(int customerId) {
        loggedInCustomerId = customerId;
    }

    // Method to get the loggedInCustomerId
    public static int getLoggedInCustomerId() {
        return loggedInCustomerId;
    }
}
