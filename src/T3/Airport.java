package T3;

import java.util.Scanner;

@SuppressWarnings("ClassCanBeRecord")
public class Airport {
    private final String name;
    private final String location;

    public Airport(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public static Airport create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of an Airport: ");
        String s = scanner.nextLine();
        System.out.print("Enter the location of an Airport: ");
        String t = scanner.nextLine();
        return new Airport(s, t);
    }

    public String getName() { return name; }

    public String getLocation() { return location; }

    public void print(String name, int count) {
        if (!(this.name.equals(name))) {
            System.out.println("#" + count + " " + this.name + " (" + this.location + ")");
        }
    }
}
