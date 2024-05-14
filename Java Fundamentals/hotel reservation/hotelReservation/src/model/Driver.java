package model;

/**
 * A driver class to test the functionality of the Customer class.
 */
public class Driver {
    /**
     * Main method to run the application.
     * @param args Command-line arguments (not used in this example).
     */
    public static void main(String[] args){
        // Try creating a valid customer with correct email format
        try{
            Customer customer1 = new Customer("first", "second","j@domain.com");
            System.out.println(customer1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error :" + e.getMessage());
        }

        // Try creating a customer with an incorrect email format to trigger the exception
        try {
            Customer customer2 = new Customer("first", "second", "email");
            System.out.println(customer2);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
