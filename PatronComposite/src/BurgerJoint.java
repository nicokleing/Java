import java.util.ArrayList;
import java.util.List;

public class BurgerJoint {
    private List<Product> productCart;

    public BurgerJoint() {
        productCart = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productCart.add(product);
    }

    public Double calculateCartPrice() {
        Double finalPrice = 0.0;
        for (Product product : productCart) {
            finalPrice += product.calculatePrice();
        }
        return finalPrice;
    }
}
