import java.util.ArrayList;
import java.util.List;

public class ProductTicket {

    private String productName;
    private Integer quantity;
    private Double pricePerProduct;


    public ProductTicket(String productName, Integer quantity, Double pricePerProduct) {
        this.productName = productName;
        this.quantity = quantity;
        this.pricePerProduct = pricePerProduct;
    }


    public Double calculateTotalPrice(){
        return pricePerProduct * quantity;
    }


}
