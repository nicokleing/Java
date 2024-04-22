import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Item> itemList;

    public Shop() {
        itemList = new ArrayList<>();
    }

    public void addItem(Item item) {
        itemList.add(item);
    }

    public Double calculatePrice() {
        Double totalPrice = 0.0;
        for (Item item : itemList) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}