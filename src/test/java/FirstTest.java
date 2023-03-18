
import org.junit.jupiter.api.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FirstTest {
    @BeforeAll
    public static void logBeforeAll() {
        System.out.println("In BeforeAll method.");
    }
    @BeforeEach
    public void logBeforeEach() {
        System.out.println("In BeforeEach method.");
    }
    @AfterAll
    public static void logAfterAll() {
        System.out.println("In AfterAll method.");
    }

    @AfterEach
    public void logAfterEach() {
        System.out.println("In AfterEach method.");
    }


    @Test
    @Order(1)
    public void firstTest2() {

    }
    @Test
    @Order(2)
    public void string_EqualsString_stringEquals() {
        Assertions.assertEquals("Test", "Test");
    }
    @Test
    @Order(3)
    public void failureString_NotEqualsString_stringNotEquals() {
        Assertions.assertEquals("Test", "test");
    }
}
