# Java-debugging
# Debugging Exercise 1: Array Manipulation
public class ArrayManipulation {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        for (int i = 0; i<= numbers. length; i++) {
            System.out.println(numbers[i]);
        }
    }
} 
# Explanation:
# The looping statement in the preceding task code is the problem, Java arrays are zero-indexed, meaning the first element is at index 0, and iteration continues until the last element numbers.length-1. If we modify the looping condition by eliminating the "=" symbol, the issue with this code is resolved.Code without error:
public class ArrayManipulation {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        for (int i = 0; i < numbers. length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
# Debugging Exercise 2: Object-Oriented Programming
class Car {
    private String make;
    private String model;
	
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void start() {
        System.out.println("Starting the car.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry");
        car.start();
        car.stop();
    }
}
# Error:
# The method stop() is undefined for the type Car
# Explanation:
# As we can see in the Main class we are trying to call the stop() method on car object, but the stop() method is not defined in the Car class, so to resolve this we can add a stop method to the Car class. Code without error:
class Car {
    private String make;
    private String model;

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public void start() {
        System.out.println("Starting the car.");
    }
    public void stop() {
        System.out.println(“Stopping the car.”);
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Camry");
        car.start();
        car.stop();
    }
}
# Output:
# Starting the car.
# Stopping the car.
# Debugging Exercise 3: Exception Handling
public class ExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        try {
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds.");
        }
        
        int result = divide(10, 0);
        System.out.println("Result: " + result);
    }

    public static int divide(int a, int b) {
        return a / b;
    }
}
# Error: 1.Array index out of bounds 2.Arithmetic Exception
# Explanation: The first error message in this code is Array index out of bounds, as we can see.while we run the program, the try and catch block is utilized to handle the exception and array index out of bounds is printed because the code attempts to access the 10th element of the numbers array while it is outside its bounds. The second error message in this code is an ArithmeticException, its not effective to divide by zero in Java so a try-catch block can be added to the main method and since zero is not allowed we can add a condition to the divide method that if b==0 before performing division and we can throw an ArithmeticException printing divison by zero is not allowed. Code without error:
public class ExceptionHandling {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5};
        
        try {
            System.out.println(numbers[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds.");
        }
        int a=10,b=0;
        try {
            int result = divide(a,b);
            System.out.println("Result: " + result);
    }

    public static int divide(int a, int b) {
        if(b==0) {
             throw new ArithmeticException(“Division by zero is not allowed.”);
        }
        else {
        return a / b;
        }
    }
}
# Output:
# Array index out of bounds.
# Division by zero is not allowed.
# Debugging Exercise 4:
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 6;
        int result = fibonacci(n);
        System.out.println("The Fibonacci number at position " + n + " is: " + result);
    }
}
# Explanation: This code has logical error. The problem in the given code is that it does not correctly handle the base cases for the Fibonacci sequence. In the current implementation, when n is less than or equal to 1,it returns n. However, this is incorrect because the Fibonacci sequence starts with 0 and 1, not 1 and 1. Code without error:
public class Fibonacci {
    public static int fibonacci(int n) {
        if (n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        int n = 6;
        int result = fibonacci(n);
        System.out.println("The Fibonacci number at position " + n + " is: " + result);
    }
}
# Output:
# The Fibonacci number at position 6 is: 8
# Debugging Exercise 5:
import java.util.*;
public class PrimeNumbers {
    public static List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = 20;
        List<Integer> primeNumbers = findPrimes(n);
        System.out.println("Prime numbers up to " + n + ": " + primeNumbers);
    }
}
# Explanation: The issue in the provided code is with the condition used to check for prime numbers. The code incorrectly marks all numbers greater than 1 as prime because the isPrime variable is set to true initially and only set to false if a divisor is found.To fix this ,you should modify the inner loop to check for divisor more accurately. Adding on to that, this code can be made more efficient my changing the inner loop condition from j<i to j<i/2. Efficient Code:
import java.util.*;
public class PrimeNumbers {
    public static List<Integer> findPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i/2; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        int n = 20;
        List<Integer> primeNumbers = findPrimes(n);
        System.out.println("Prime numbers up to " + n + ": " + primeNumbers);
    }
}
# Output:
# Prime numners up to 20: [2,3,5,7,11,13,17,19]
Output:
Prime numbers up to 20: [2, 3, 4, 5, 7, 11, 13, 17, 19]
