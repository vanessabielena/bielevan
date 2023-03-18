package cz.cvut.fel.ts1;

public class Calculator {

    public int addition(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }

    public int division(int a, int b) {
        if (b == 0) {
            try {
                ThrowException();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return a / b;
    }

    public void ThrowException() throws Exception {
        throw new Exception("Division by zero");
    }
}
