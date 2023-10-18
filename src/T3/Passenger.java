package T3;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

@SuppressWarnings("ClassCanBeRecord")
public class Passenger {
    private final String name;
    private final int age;

    public Passenger(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Passenger create() {
        Scanner scanner = new Scanner(System.in);
        int k;
        String s;
        System.out.print("Enter the name of a Passenger: ");
        s = scanner.nextLine();
        System.out.print("Enter the age of a Passenger: ");
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

    public String getName() { return name; }

    public int getAge() { return age; }

    public void print(int count) {
        System.out.println("#" + count + " " + this.name + " (" + this.age + ")");
    }
}
