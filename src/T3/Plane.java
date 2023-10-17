package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Plane {
    String name;
    Airport location;

    public Plane(String name, Airport location) {
        this.name = name;
        this.location = location;
    }

    public static Plane create(ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of a new Plane: ");
        String s = scanner.nextLine();
        int count = 0;
        int k;
        for (Airport airport : airports) {
            airport.print(count);
            count++;
        }
        System.out.print("Enter the ID of the location of a new Plane: ");
        if (isViable(airports.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        } else return null;
        return new Plane(s, airports.get(k));
    }

    public void print(int count) {
        System.out.println("#" + count + " " + this.name + " (" + this.location.name + "(" + this.location.location + "))");
    }
}
