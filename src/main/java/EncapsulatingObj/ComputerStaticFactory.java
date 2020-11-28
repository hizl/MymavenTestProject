package EncapsulatingObj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.Scanner;

public class ComputerStaticFactory {

    static Scanner scanner = new Scanner(System.in);

    public static Computer newInstance(Scanner scanner) {
        if (scanner.nextLine().equals("mac")) {
            return new MacBook(5000);
        } else if (scanner.nextLine().equals("lap")) {
            return new LapTop(2000);
        }
        return null;
    }


    public static void main(String[] args) {
        Computer<Integer> computer;
        System.out.println(newInstance(scanner));
    }
}

class FactoryClient {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {
        Computer pc = ComputerStaticFactory.newInstance(scanner);
        System.out.println(pc instanceof MacBook);

        Computer laptop = ComputerStaticFactory.newInstance(scanner);
        System.out.println(laptop instanceof LapTop);
    }
}


abstract class Computer<T> {
    @Getter
    @Setter
    private T ram;
    private T cpu;
}

@ToString
@AllArgsConstructor
class MacBook<T> extends Computer<T> {
    @Override
    public T getRam() {
        return super.getRam();
    }

    @Override
    public void setRam(T ram) {
        super.setRam(ram);
    }


    @Getter
    @Setter
    private T price;
}

@ToString
@AllArgsConstructor
class LapTop<T> extends Computer<T> {

    @Getter
    @Setter
    private T price;


}