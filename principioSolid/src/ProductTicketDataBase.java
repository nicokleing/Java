import java.util.ArrayList;
import java.util.List;

public class ProductTicketDataBase {
    private List<ProductTicket> productTicketList;

    public ProductTicketDataBase(){
        productTicketList = new ArrayList<>();
    }

    public void addProductTicket(ProductTicket productTicket){
        productTicketList.add(productTicket);
    }

    public Double calculateTotalEarnings(){
        Double totalPrice = 0.0;
        for (ProductTicket productTicket:productTicketList){
            totalPrice += productTicket.calculateTotalPrice();
        }
        return totalPrice;
    }
}
