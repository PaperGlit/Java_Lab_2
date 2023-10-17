package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isTime;
import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Route {
    Plane plane;
    Airport destination;
    String timeD;
    String timeA;

    public Route(Plane plane, Airport destination, String timeD, String timeA) {
        this.plane = plane;
        this.destination = destination;
        this.timeD = timeD;
        this.timeA = timeA;
    }

    public static Route create(ArrayList<Plane> planes, ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int j, k;
        String s, t;
        for (Plane plane : planes) {
            plane.print(count);
            count++;
        }
        System.out.print("Select the ID of the plane for this route: ");
        if (isViable(planes.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        } else return null;
        count = 0;
        for (Airport airport : airports) {
            airport.print(count);
            count++;
        }
        System.out.print("Select the ID of the airport for the destination of this route: ");
        if (isViable(airports.size(), scanner.nextLine())) {
            j = parseInt(scanner.nextLine());
        } else return null;
        System.out.print("Select the time of departure for this route (HH:MM 24-hour format): ");
        if (isTime(scanner.nextLine())) {
            s = scanner.nextLine();
        } else return null;
        System.out.print("Select the time of arrival for this route (HH:MM 24-hour format): ");
        if (isTime(scanner.nextLine())) {
            t = scanner.nextLine();
        } else return null;
        return new Route(planes.get(k), airports.get(j), s, t);
    }

    public void print(int count) {
        System.out.println("#" + count + " " + this.timeD + " - " + this.timeA + " " +
                this.plane.location.location + " - " + this.destination.location +
                " (" + this.plane.name + ")");
    }
}
