package Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.StandardItem;

import java.util.ArrayList;

public class TestStandartItem {

    @Test
    public void testConstructor() {
        int id = 10;
        String name = "Name";
        float price = 1.5f;
        String category = "category";
        int loyaltyPoints = 3;
        StandardItem si = new StandardItem(id, name, price, category, loyaltyPoints);
        Assertions.assertEquals(id, si.getID());
        Assertions.assertEquals(name, si.getName());
        Assertions.assertEquals(price, si.getPrice());
        Assertions.assertEquals(category, si.getCategory());
        Assertions.assertEquals(loyaltyPoints, si.getLoyaltyPoints());
    }


    @Test
    public void testCopy() {
        StandardItem item1 = new StandardItem(15, "Name", 10.0f, "category", 5);
        StandardItem item2 = item1.copy();
        Assertions.assertEquals(item1, item2);
    }

    @Test
    public void testNotEquals() {
        StandardItem item1 = new StandardItem(1, "Name1", 1.0f, "category1", 5);
        StandardItem item2 = new StandardItem(2, "Name2", 2.0f, "category2", 10);
        Assertions.assertNotEquals(item1, item2);
    }

    @Test
    public void testEquals() {
        StandardItem item1 = new StandardItem(1, "Name", 10.0f, "category", 5);
        StandardItem item2 = new StandardItem(1, "Name", 10.0f, "category", 5);
        Assertions.assertTrue(item1.equals(item2));
    }

    StandardItem item1 = new StandardItem(1, "Name", 10.0f, "Category", 5);
    StandardItem item2 = new StandardItem(2, "Name 2", 20.0f, "Category 2", 10);
    StandardItem item3 = new StandardItem(1, "Name", 10.0f, "Category", 5);
    StandardItem item4 = new StandardItem(1, "Name", 5.0f, "Category", 5);

//    @CsvSource({"", "-4,6,2", "1,2,1"})
//    @ParameterizedTest( name = "Comparing {0} and {1}, expected result should be {2}")
//    public void addition_addsAAndB_returnsC(int a, int b, int c) {
//        int expectedResult = c;
//        int result = calculator.addition(a, b);
//
//        Assertions.assertEquals(expectedResult, result);
//    }

    @ParameterizedTest
    @CsvSource({
            "1,item1,10.0,category1,10,1,item1,10.0,category1,10,true",
            "2,item2,20.0,category2,20,1,item1,10.0,category1,10,false",
            "3,item3,30.0,category1,30,3,item3,30.0,category1,30,true"
    })
    void testEquals(int id1, String name1, float price1, String category1, int loyaltyPoints1,
                    int id2, String name2, float price2, String category2, int loyaltyPoints2,
                    boolean expected) {
        StandardItem item1 = new StandardItem(id1, name1, price1, category1, loyaltyPoints1);
        StandardItem item2 = new StandardItem(id2, name2, price2, category2, loyaltyPoints2);
        Assertions.assertEquals(expected, item1.equals(item2));
    }

}
