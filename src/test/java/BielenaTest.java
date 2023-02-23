import cz.cvut.fel.ts1.Bielena;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BielenaTest {
    @Test
    public void factorialTest() {
        Assertions.assertEquals(120, Bielena.factorialRecursive(5));
    }
}
