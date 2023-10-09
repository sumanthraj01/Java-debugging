package vignesh;

public class ExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        try {
            System.out.println(numbers[10]); // This will throw an ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds.");
        }
        
        try {
            int result = divide(10, 0); // This will throw an ArithmeticException
            System.out.println("Result: " + result); // This line won't be reached if an exception is thrown
        } catch (ArithmeticException e) {
            System.out.println("Division by zero error.");
        }
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
}