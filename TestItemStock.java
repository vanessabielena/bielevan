package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.Item;
import storage.ItemStock;

public class TestItemStock {
    @Test
    public void testConstructor() {
        Item item = new Item(7, "item", 6.66f, "category");
        ItemStock itemStock = new ItemStock(item);
        Assertions.assertEquals(item, itemStock.getItem());
        Assertions.assertEquals(0, itemStock.getCount());
    }

    @CsvSource({"1, 1, 2", "2, 3, 5", "0, 5, 5"})
    @ParameterizedTest
    public void testIncreaseItemCount(int initialCount, int addToCount, int expectedCount) {
        Item item = new Item(8, "item", 66.6f, "category");
        ItemStock itemStock = new ItemStock(item);
        itemStock.setCount(initialCount);
        itemStock.IncreaseItemCount(addToCount);
        Assertions.assertEquals(expectedCount, itemStock.getCount());
    }

    @CsvSource({"5, 2, 3", "2, 2, 0", "0, 1, -1"})
    @ParameterizedTest
    public void testDecreaseItemCount(int initialCount, int removeFromCount, int expectedCount) {
        Item item = new Item(9, "item", 66.6f, "category");
        ItemStock itemStock = new ItemStock(item);
        itemStock.setCount(initialCount);
        itemStock.decreaseItemCount(removeFromCount);
        Assertions.assertEquals(expectedCount, itemStock.getCount());
    }
}
