package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Plane {
    private String name;
    private Airport airport;

    public Plane(String name, Airport airport) {
        this.name = name;
        this.airport = airport;
    }

    public static Plane create(ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of a new Plane: ");
        String s = scanner.nextLine(), t;
        int count = 0;
        int k;
        for (Airport airport : airports) {
            airport.print(null, count);
            count++;
        }
        System.out.print("Enter the ID of the location of a new Plane: ");
        t = scanner.nextLine();
        if (isViable(airports.size(), t)) {
            k = parseInt(t);
        }
        else return null;
        return new Plane(s, airports.get(k));
    }

    public String getName() { return name; }

    public Airport getAirport() { return airport; }

    public void edit(ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        String t;
        System.out.print("Enter the new name of a Plane: ");
        this.name = scanner.nextLine();
        int count = 0, k;
        for (Airport airport : airports) {
            airport.print(null, count);
            count++;
        }
        while (true) {
            System.out.print("Enter the ID of the new location of a Plane: ");
            t = scanner.nextLine();
            if (isViable(airports.size(), t)) {
                k = parseInt(t);
                this.airport = airports.get(k);
                return;
            }
        }
    }

    public void print(int count) {
        System.out.println("#" + count + " " + this.name + " (" + this.airport.getName() + "(" + this.airport.getLocation() + "))");
    }
}
