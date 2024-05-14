package model;

/**
 * Represents a customer in the hotel reservation system.
 */
public class Customer {
    // Fields for the first name, last name, and email address of the customer
    private String firstName;
    private String lastName;
    private String email;

    /**
     * Constructor to create a new Customer object.
     * @param firstName The first name of the customer.
     * @param lastName The last name of the customer.
     * @param email The email address of the customer.
     * @throws IllegalArgumentException if the email does not match the specified format.
     */
    public Customer(String firstName, String lastName, String email) {
        // Regular expression to validate the email format
        if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    /**
     * Provides a string representation of the Customer object, which includes first name, last name, and email.
     * @return A string representation of the customer details.
     */
    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
