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

    public static Route create(ArrayList<Plane> planes, ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int j, k;
        String s, t, u;
        for (Plane plane : planes) {
            plane.print(count);
            count++;
        }
        System.out.print("Select the ID of the plane for this route: ");
        u = scanner.nextLine();
        if (isViable(planes.size(), u)) {
            k = parseInt(u);
        } else return null;
        count = 0;
        for (Airport airport : airports) {
            airport.print(planes.get(k).getAirport().getName(), count);
            count++;
        }
        System.out.print("Select the ID of the airport for the destination of this route: ");
        u = scanner.nextLine();
        if (isViable(airports.size(), u)) {
            j = parseInt(u);
        } else return null;
        if (airports.get(j) == planes.get(k).getAirport()) {
            System.out.println("Error: value is out-of-reach");
            return null;
        }
        System.out.print("Select the time of departure for this route (HH:MM 24-hour format): ");
        s = scanner.nextLine();
        if (!isTime(s)) return null;
        System.out.print("Select the time of arrival for this route (HH:MM 24-hour format): ");
        t = scanner.nextLine();
        if (!isTime(t)) return null;
        return new Route(planes.get(k), airports.get(j), s, t);
    }

    public Plane getPlane() { return plane; }

    public Airport getDestination() { return destination; }

    public String getTimeD() { return timeD; }

    public String getTimeA() { return timeA; }

    public void edit(ArrayList<Plane> planes, ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        int count = 0, j, k;
        String s, t, u;
        for (Plane plane : planes) {
            plane.print(count);
            count++;
        }
        while (true) {
            System.out.print("Select the ID of the plane for this route: ");
            u = scanner.nextLine();
            if (isViable(planes.size(), u)) {
                k = parseInt(u);
                this.plane = planes.get(k);
                break;
            }
        }
        count = 0;
        for (Airport airport : airports) {
            airport.print(planes.get(k).getAirport().getName(), count);
            count++;
        }
        while (true) {
            System.out.print("Select the ID of the airport for the destination of this route: ");
            u = scanner.nextLine();
            if (isViable(airports.size(), u)) {
                j = parseInt(u);
            } else continue;
            if (airports.get(j) == planes.get(k).getAirport()) {
                System.out.println("Error: value is out-of-reach");
            } else continue;
            this.destination = airports.get(j);
            break;
        }
        while (true) {
            System.out.print("Select the time of departure for this route (HH:MM 24-hour format): ");
            s = scanner.nextLine();
            if (!isTime(s)) continue;
            System.out.print("Select the time of arrival for this route (HH:MM 24-hour format): ");
            t = scanner.nextLine();
            if (!isTime(t)) continue;
            this.timeD = s;
            this.timeA = t;
            return;
        }
    }

    public void print(int count) {
        System.out.println("#" + count + " " + this.timeD + " - " + this.timeA + " " +
                this.plane.getAirport().getLocation() + " - " + this.destination.getLocation() +
                " (" + this.plane.getName() + ")");
    }
}
