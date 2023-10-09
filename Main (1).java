package vignesh;

class Car {
    public void start() {
        System.out.println("Starting the car.");
    }

    public void stop() {
        System.out.println("Stopping the car.");
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.stop();
    }
}



