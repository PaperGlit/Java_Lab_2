package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

@SuppressWarnings("ClassCanBeRecord")
public class Plane {
    private final String name;
    private final Airport location;

    public Plane(String name, Airport location) {
        this.name = name;
        this.location = location;
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

    public Airport getLocation() { return location; }

    public void print(int count) {
        System.out.println("#" + count + " " + this.name + " (" + this.location.getName() + "(" + this.location.getLocation() + "))");
    }
}
