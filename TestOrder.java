package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;

import java.util.ArrayList;

public class TestOrder {
    @Test
    public void testOrderConstructorWithState() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item(101, "goat", 1.0f, "category1");
        Item item2 = new Item(102, "candle", 2.0f, "category2");
        cart.addItem(item1);
        cart.addItem(item2);
        Order order = new Order(cart, "Lucifer Morningstar", "address", 666);

        ArrayList<Item> items = order.getItems();

        Assertions.assertEquals(2, items.size());
        Assertions.assertTrue(items.contains(item1));
        Assertions.assertTrue(items.contains(item2));
        Assertions.assertEquals("Lucifer Morningstar", order.getCustomerName());
        Assertions.assertEquals("address", order.getCustomerAddress());
        Assertions.assertEquals(666, order.getState());
    }
    @Test
    public void testOrderConstructorWithoutState() {
        ShoppingCart cart = new ShoppingCart();
        Item item1 = new Item(103, "goat", 1.0f, "category1");
        cart.addItem(item1);
        Order order = new Order(cart, "Asmodeus", "address", 666);

        ArrayList<Item> items = order.getItems();

        Assertions.assertEquals(1, items.size());
        Assertions.assertTrue(items.contains(item1));
        Assertions.assertEquals("Asmodeus", order.getCustomerName());
        Assertions.assertEquals("address", order.getCustomerAddress());
        Assertions.assertEquals(666, order.getState());
    }

    @Test
    public void testOrderConstructorWithNullValues() {
        ShoppingCart cart = new ShoppingCart();
//        Item item1 = new Item(101, "goat", 1.0f, "category1");
//        cart.addItem(item1);
        Order order = new Order(null, "Beelzebub", "address", 666);

        ArrayList<Item> items = order.getItems();

//        Assertions.assertEquals(1, items.size());
//        Assertions.assertTrue(items.contains(item1));
        Assertions.assertEquals("Beelzebub", order.getCustomerName());
        Assertions.assertEquals("address", order.getCustomerAddress());
        Assertions.assertEquals(666, order.getState());
    }
}
