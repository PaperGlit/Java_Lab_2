package T3;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Passenger {
    private String name;

    private int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Passenger create() {
        Scanner scanner = new Scanner(System.in);
        int k;
        String s;
        System.out.print("Enter the name of a new Passenger: ");
        s = scanner.nextLine();
        System.out.print("Enter the age of a new Passenger: ");
        try {
            k = parseInt(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Error: the value is not an integer");
            return null;
        }
        if (k <= 0) {
            System.out.println("Error: the value cannot be negative nor zero");
            return null;
        }

        return new Passenger(s, k);
    }

    public void edit() {
        Scanner scanner = new Scanner(System.in);
        int k;
        System.out.print("Enter the new name of a Passenger: ");
        this.name = scanner.nextLine();
        while (true) {
            System.out.print("Enter the new age of a Passenger: ");
            try {
                k = parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Error: the value is not an integer");
                continue;
            }
            if (k <= 0) {
                System.out.println("Error: the value cannot be negative nor zero");
                continue;
            }
            this.age = k;
            return;
        }
    }

    public String toString(){
        return this.name + " (" + this.age + ")";
    }
}
