package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isTime;
import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

@SuppressWarnings("ClassCanBeRecord")
public class Route {
    private final Plane plane;
    private final Airport destination;
    private final String timeD;
    private final String timeA;

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
            airport.print(planes.get(k).getLocation().getName(), count);
            count++;
        }
        System.out.print("Select the ID of the airport for the destination of this route: ");
        u = scanner.nextLine();
        if (isViable(airports.size(), u)) {
            j = parseInt(u);
        } else return null;
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

    public void print(int count) {
        System.out.println("#" + count + " " + this.timeD + " - " + this.timeA + " " +
                this.plane.getLocation().getLocation() + " - " + this.destination.getLocation() +
                " (" + this.plane.getName() + ")");
    }
}
