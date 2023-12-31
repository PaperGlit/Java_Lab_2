package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isTime;
import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Route {
    private Plane plane;

    private Airport destination;

    private String timeD;

    private String timeA;

    public Route(Plane plane, Airport destination, String timeD, String timeA) {
        this.plane = plane;
        this.destination = destination;
        this.timeD = timeD;
        this.timeA = timeA;
    }

    public Plane getPlane() { return plane; }

    public Airport getDestination() { return destination; }

    public static Route create(ArrayList<Plane> planes, ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int j, k;
        String s, t, u;
        for (Plane plane : planes) {
            System.out.println("#" + count + " " + plane);
            count++;
        }
        System.out.print("Select the ID of the plane for this new route: ");
        u = scanner.nextLine();
        if (isViable(planes.size(), u)) {
            k = parseInt(u);
        } else return null;
        count = 0;
        for (Airport airport : airports) {
            if (planes.get(k).getAirport() != airport) {
                System.out.println("#" + count + " " + airport);
            }
            count++;
        }
        System.out.print("Select the ID of the airport for the destination of this new route: ");
        u = scanner.nextLine();
        if (isViable(airports.size(), u)) {
            j = parseInt(u);
        } else return null;
        if (airports.get(j) == planes.get(k).getAirport()) {
            System.out.println("Error: value is out-of-reach");
            return null;
        }
        System.out.print("Select the time of departure for this new route (HH:MM 24-hour format): ");
        s = scanner.nextLine();
        if (!isTime(s)) return null;
        System.out.print("Select the time of arrival for this new route (HH:MM 24-hour format): ");
        t = scanner.nextLine();
        if (!isTime(t)) return null;
        return new Route(planes.get(k), airports.get(j), s, t);
    }

    public void edit(ArrayList<Plane> planes, ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        int count = 0, j, k;
        String s, t, u;
        for (Plane plane : planes) {
            System.out.println("#" + count + " " + plane);
            count++;
        }
        while (true) {
            System.out.print("Select the ID of the new plane for this route: ");
            u = scanner.nextLine();
            if (isViable(planes.size(), u)) {
                k = parseInt(u);
                this.plane = planes.get(k);
                break;
            }
        }
        count = 0;
        for (Airport airport : airports) {
            if (planes.get(k).getAirport() != airport) {
                System.out.println("#" + count + " " + airport);
            }
            count++;
        }
        while (true) {
            System.out.print("Select the ID of the new airport for the destination of this route: ");
            u = scanner.nextLine();
            if (isViable(airports.size(), u)) {
                j = parseInt(u);
            } else continue;
            if (airports.get(j) == planes.get(k).getAirport()) {
                System.out.println("Error: value is out-of-reach");
                continue;
            }
            this.destination = airports.get(j);
            break;
        }
        while (true) {
            System.out.print("Select the new time of departure for this route (HH:MM 24-hour format): ");
            s = scanner.nextLine();
            if (!isTime(s)) continue;
            System.out.print("Select the new time of arrival for this route (HH:MM 24-hour format): ");
            t = scanner.nextLine();
            if (!isTime(t)) continue;
            this.timeD = s;
            this.timeA = t;
            return;
        }
    }

    public String toString() {
        return this.timeD + " - " + this.timeA + " " + this.plane.getAirport().getLocation() +
                " - " + this.destination.getLocation() + " (" + this.plane.getName() + ")";
    }
}
