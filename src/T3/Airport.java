package T3;

import java.util.Scanner;

public class Airport {
    private String name;
    private String location;

    public Airport(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public static Airport create() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of a new Airport: ");
        String s = scanner.nextLine();
        System.out.print("Enter the location of a new Airport: ");
        String t = scanner.nextLine();
        return new Airport(s, t);
    }

    public String getLocation() { return location; }

    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the new name of an Airport: ");
        this.name = scanner.nextLine();
        System.out.print("Enter the new location of an Airport: ");
        this.location = scanner.nextLine();
    }

    public String toString() {
        return this.name + " (" + this.location + ")";
    }
}
