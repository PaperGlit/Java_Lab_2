package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Timetable {
    private final Route route;
    private final String schedule;

    public Timetable(Route route, String schedule) {
        this.route = route;
        this.schedule = schedule;
    }

    public static Timetable create(ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        int count = 0, k;
        String s, t;
        for (Route route : routes) {
            route.print(count);
            count++;
        }
        System.out.print("Select the ID of the route for this Timetable: ");
        t = scanner.nextLine();
        if (isViable(routes.size(), t)) {
            k = parseInt(t);
        } else return null;
        System.out.print("Enter the schedule for this route (f.e. Tue-Sat): ");
        s = scanner.nextLine();
        return new Timetable(routes.get(k), s);
    }

    public Route getRoute() { return route; }

    public void print(int count) {
        System.out.println("#" + count + " (" + this.route.getTimeD() + " - " + this.route.getTimeA() + " " + this.schedule + ") "
                + this.route.getPlane().getAirport().getLocation() + " - " + this.route.getDestination().getLocation());
    }
}
