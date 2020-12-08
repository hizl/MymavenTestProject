package courses;

import java.util.*;

public class ClassStack {
    public static void stackBusExample() {
        Stack<Passenger> stackBus = new Stack<>();
        addPassenger(stackBus);
        Passenger passenger = new Passenger("STOP", " STOP");
        for (Passenger o : stackBus.toArray(new Passenger[0])) {
            System.out.println(o);
        }
        System.out.println("++++++++++++++++++");


        while (!stackBus.isEmpty()) {
            System.out.println(stackBus.pop());
        }
        System.out.println(stackBus.pop()); // empty stack clean pop

    }

    public static void addPassenger(Stack<Passenger> stackBus) {
        stackBus.push(new Passenger("Tom", "Smith"));
        stackBus.push(new Passenger("Peter", "Meet"));
        stackBus.push(new Passenger("Vas", "Yang"));
        Passenger passenger = new Passenger("Cristy", "Sl");
        stackBus.push(new Passenger("Jess", "Smith"));
        stackBus.push(passenger);

    }


    public static void main(String[] args) {
        ClassStack.stackBusExample();
    }

    //POJO plain old java object
    private static class Passenger {
        String name;
        String surname;
        static int seatNumber;

        public Passenger(String name, String surname) {
            this.name = name;
            this.surname = surname;
            seatNumber++;
        }

        @Override
        public String toString() {
            return "Passenger{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    '}';
        }
    }


}
