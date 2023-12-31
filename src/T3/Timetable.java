package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isDate;
import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Timetable {
    private final Route route;

    private final String schedule;

    public Timetable(Route route, String schedule) {
        this.route = route;
        this.schedule = schedule;
    }

    public Route getRoute() { return route; }

    public static Timetable create(ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        int count = 0, k;
        String s, t;
        for (Route route : routes) {
            System.out.println("#" + count + " " + route);
            count++;
        }
        System.out.print("Select the ID of the route for this new Timetable: ");
        t = scanner.nextLine();
        if (isViable(routes.size(), t)) {
            k = parseInt(t);
        } else return null;
        System.out.print("Enter the schedule for this route (f.e. Tue-Sat): ");
        s = scanner.nextLine();
        if (!isDate(s)) {
            System.out.println("Error: incorrect date format detected");
            return null;
        }
        return new Timetable(routes.get(k), s);
    }

    public String toString() {
        return this.schedule + " " + this.route;
    }
}
