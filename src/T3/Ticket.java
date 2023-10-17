package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Ticket {
    static double p = 100;
    double price;
    Passenger passenger;
    Route route;

    public Ticket(Passenger passenger, Route route) {
        this.price = p;
        this.passenger = passenger;
        this.route = route;
    }

    public double getPrice() { return this.price; }

    public static double getSetPrice() { return p; }

    public static void setPrice(double p) {
        Ticket.p = p;
    }

    public static Ticket sell(ArrayList<Passenger> passengers, ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int j, k;
        for (Passenger passenger : passengers) {
            passenger.print(count);
            count++;
        }
        System.out.print("Select the ID of the passenger for this Ticket: ");
        if (isViable(passengers.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        } else return null;
        count = 0;
        for (Route route : routes) {
            route.print(count);
            count++;
        }
        System.out.print("Select the ID of the route for this Ticket: ");
        if (isViable(routes.size(), scanner.nextLine())) {
            j = parseInt(scanner.nextLine());
        } else return null;
        return new Ticket(passengers.get(k), routes.get(j));
    }
}
