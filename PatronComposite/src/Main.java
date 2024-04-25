public class Main {
    public static void main(String[] args) {

        // Create individual products
        ProductSingle hamburger = new ProductSingle("Hamburger", 5.0);
        ProductSingle fries = new ProductSingle("Fries", 2.0);
        ProductSingle cola = new ProductSingle("Cola", 1.0);

        // Create a BurgerJoint object
        BurgerJoint burgerjoint = new BurgerJoint();

        // Add individual products to the cart
        burgerjoint.addProduct(hamburger);
        burgerjoint.addProduct(fries);
        burgerjoint.addProduct(cola);

        // Create a combo product
        ProductComposite productComposite = new ProductComposite("Combo", 0.1); // 10% discount for the combo

        // Add individual products to the combo
        productComposite.addProduct(hamburger);
        productComposite.addProduct(fries);
        productComposite.addProduct(cola);

        // Add the combo product to the cart
        burgerjoint.addProduct(productComposite);

        ProductComposite megaProductComposite = new ProductComposite("Mega Combo", 0.25);
        megaProductComposite.addProduct(hamburger);
        megaProductComposite.addProduct(fries);
        megaProductComposite.addProduct(cola);
        megaProductComposite.addProduct(hamburger); // Add another hamburger for Mega Combo

// Add both combos to the BurgerJoint
        burgerjoint.addProduct(productComposite);
        burgerjoint.addProduct(megaProductComposite);

        // Calculate and print the total cart price
        double totalPrice = burgerjoint.calculateCartPrice();
        System.out.println("Total Cart Price: $" + totalPrice);
    }
}