package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Timetable {
    Route route;
    String schedule;

    public Timetable(Route route, String schedule) {
        this.route = route;
        this.schedule = schedule;
    }

    public static Timetable create(ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int k;
        String s;
        for (Route route : routes) {
            route.print(count);
            count++;
        }
        System.out.print("Select the ID of the route for this Timetable: ");
        if (isViable(routes.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        } else return null;
        System.out.print("Enter the schedule for this route (f.e. Tue-Sat): ");
        s = scanner.nextLine();
        return new Timetable(routes.get(k), s);
    }

    public void print(int count) {
        System.out.println("#" + count + " (" + this.route.timeD + " - " + this.route.timeA + " " + this.schedule + ") "
                + this.route.plane.location.location + " - " + this.route.destination.location);
    }
}
