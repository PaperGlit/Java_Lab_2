package T3;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Integer.parseInt;

public class Ticket {
    static double p = 100;

    private final double price;

    private final Passenger passenger;

    private final Route route;

    public Ticket(Passenger passenger, Route route) {
        this.price = p;
        this.passenger = passenger;
        this.route = route;
    }

    public double getPrice() { return price; }

    public Route getRoute() { return route; }

    public Passenger getPassenger() { return  passenger; }

    public static double getSetPrice() { return p; }

    public static void setPrice(double p) {
        Ticket.p = p;
    }

    public static Ticket sell(ArrayList<Passenger> passengers, ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        String s;
        int count = 0, j, k;
        for (Passenger passenger : passengers) {
            System.out.println("#" + count + " " + passenger);
            count++;
        }
        System.out.print("Select the ID of the passenger for this new Ticket: ");
        s = scanner.nextLine();
        if (isViable(passengers.size(), s)) {
            k = parseInt(s);
        } else return null;
        count = 0;
        for (Route route : routes) {
            System.out.println("#" + count + " " + route);
            count++;
        }
        System.out.print("Select the ID of the route for this new Ticket: ");
        s = scanner.nextLine();
        if (isViable(routes.size(), s)) {
            j = parseInt(s);
        } else return null;
        return new Ticket(passengers.get(k), routes.get(j));
    }

    public String toString() {
        return this.passenger + " - " + this.route + " (" + this.price + ")";
    }
}
