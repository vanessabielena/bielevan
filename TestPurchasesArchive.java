
import archive.ItemPurchaseArchiveEntry;
import archive.PurchasesArchive;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.mockito.Mockito;
import shop.Item;
import shop.Order;
import shop.ShoppingCart;

public class TestPurchasesArchive {
    private PurchasesArchive archive;
    private Item item;
    private Order order;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    @BeforeEach
    public void setUpStream() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStream() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @BeforeEach
    public void setUpPurchaseArchiveItemOrder() {
        archive = new PurchasesArchive();
        item = Mockito.mock(Item.class);
        order = Mockito.mock(Order.class);
    }

//    @Test
//    public void testPrintItemPurchaseStatistics() {
//        PurchasesArchive archive = new PurchasesArchive();
//        Item item1 = new Item(1, "item1", 1.7f, "category");
//        Item item2 = new Item(2, "item2", 2.8f, "category");
//        ItemPurchaseArchiveEntry entry1 = new ItemPurchaseArchiveEntry(item1);
//        ItemPurchaseArchiveEntry entry2 = new ItemPurchaseArchiveEntry(item2);
//        entry1.increaseCountHowManyTimesHasBeenSold(3);
//        entry2.increaseCountHowManyTimesHasBeenSold(5);
//        archive.getItemPurchaseArchive().put(1, entry1);
//        archive.getItemPurchaseArchive().put(2, entry2);
//        archive.printItemPurchaseStatistics();
//        String expectedOutput = "ITEM PURCHASE STATISTICS:\nSTOCK OF ITEM:  Item 1    PIECES SOLD: 3\nSTOCK OF ITEM:  Item 2    PIECES SOLD: 5\n";
//        Assertions.assertEquals(expectedOutput, outContent.toString());
//    }

    @Test
    public void testPrintItemPurchaseStatistics() {
        ItemPurchaseArchiveEntry mockItemPurchaseArchiveEntry = Mockito.mock(ItemPurchaseArchiveEntry.class);
        Mockito.when(mockItemPurchaseArchiveEntry.toString()).thenReturn("mockItemPurchaseArchiveEntry");
        HashMap<Integer, ItemPurchaseArchiveEntry> itemPurchaseArchive = new HashMap<>();
        itemPurchaseArchive.put(1, mockItemPurchaseArchiveEntry);
        archive = new PurchasesArchive(itemPurchaseArchive, new ArrayList<>());
        archive.printItemPurchaseStatistics();
        String expectedOutput = "ITEM PURCHASE STATISTICS:\nitemPurchaseArchiveEntry\n";

        Assertions.assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testGetHowManyTimesHasBeenItemSold() {
        int expectedCount = 5;
        ItemPurchaseArchiveEntry itemPurchaseArchiveEntry = Mockito.mock(ItemPurchaseArchiveEntry.class);
        Mockito.when(itemPurchaseArchiveEntry.getCountHowManyTimesHasBeenSold()).thenReturn(expectedCount);
        HashMap<Integer, ItemPurchaseArchiveEntry> itemPurchaseArchive = new HashMap<>();
        itemPurchaseArchive.put(1, itemPurchaseArchiveEntry);
        archive = new PurchasesArchive(itemPurchaseArchive, new ArrayList<>());
        Mockito.when(item.getID()).thenReturn(1);

        Assertions.assertEquals(expectedCount, archive.getHowManyTimesHasBeenItemSold(item));
    }

    @Test
    public void testPutOrderToPurchasesArchive() {
        ArrayList<Item> orderItems = new ArrayList<>();
        orderItems.add(item);
        Mockito.when(order.getItems()).thenReturn(orderItems);
        Mockito.when(item.getID()).thenReturn(1);
        archive.putOrderToPurchasesArchive(order);

        Assertions.assertEquals(1, archive.getHowManyTimesHasBeenItemSold(item));
    }

//    @Test
//    public void testGetHowManyTimesHasBeenItemSold() {
//        PurchasesArchive archive = new PurchasesArchive();
//        Item item1 = new Item(1, "item1", 1.1f, "category");
//        Item item2 = new Item(2, "item2", 2.2f, "category");
//        Item item3 = new Item(3, "item3", 3.3f, "category");
//        Order order1 = new Order(new ShoppingCart(new ArrayList<Item>(List.of(item1, item2, item3))), "Belphegor", "address1");
//        Order order2 = new Order(new ShoppingCart(new ArrayList<Item>(List.of(item2, item3))), "Mammon", "address2");
//        Order order3 = new Order(new ShoppingCart(new ArrayList<Item>(List.of(item3))), "Leviathan", "address3");
//        archive.putOrderToPurchasesArchive(order1);
//        archive.putOrderToPurchasesArchive(order2);
//        archive.putOrderToPurchasesArchive(order3);
//        int soldCount1 = archive.getHowManyTimesHasBeenItemSold(item1);
//        int soldCount2 = archive.getHowManyTimesHasBeenItemSold(item2);
//        int soldCount3 = archive.getHowManyTimesHasBeenItemSold(item3);
//        Assertions.assertEquals(1, soldCount1);
//        Assertions.assertEquals(2, soldCount2);
//        Assertions.assertEquals(3, soldCount3);
//    }
//
//    @Test
//    public void testPutOrderToPurchasesArchive() {
//        PurchasesArchive archive = new PurchasesArchive();
//        Item item1 = new Item(1, "item1", 1.1f, "category");
//        Item item2 = new Item(2, "item2", 2.2f, "category");
//        Order order1 = new Order(new ShoppingCart(new ArrayList<Item>(List.of(item1, item2))), "Belphegor", "address1");
//        Order order2 = new Order(new ShoppingCart(new ArrayList<Item>(List.of(item2))), "Mammon", "address2");
//        archive.putOrderToPurchasesArchive(order1);
//        archive.putOrderToPurchasesArchive(order2);
//        Assertions.assertEquals(2, archive.getOrderArchive().size());
//        Assertions.assertEquals(1, archive.getItemPurchaseArchive().get(item1.getID()).getCountHowManyTimesHasBeenSold());
//        Assertions.assertEquals(2, archive.getItemPurchaseArchive().get(item2.getID()).getCountHowManyTimesHasBeenSold());
//    }


}
