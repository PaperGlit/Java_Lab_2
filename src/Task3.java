import T3.*;

import java.util.ArrayList;
import java.util.Scanner;

import static T3.Additions.isViable;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Task3 {
    public static void airport() {
        ArrayList<Plane> planes = new ArrayList<>();
        ArrayList<Airport> airports = new ArrayList<>();
        ArrayList<Route> routes = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        ArrayList<Timetable> timetables = new ArrayList<>();
        ArrayList<Ticket> tickets = new ArrayList<>();

        while (true) {
            System.out.print("1 - Airports, 2 - Planes, 3 - Routes, 4 - Passengers, 5 - Timetable, 6 - Tickets, everything else - exit: ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            int k, count;
            switch (s) {
                case "1":
                    System.out.print("1 - Create a new Airport, 2 - Edit an Airport, 3 - Delete an Airport, anything else - return: ");
                    s = scanner.nextLine();
                    Airport ap;
                    switch (s) {
                        case "1":
                            airports.add(Airport.create());
                            System.out.println("New Airport was added successfully");
                            break;
                        case "2":
                            count = 0;
                            for(Airport airport : airports) {
                                airport.print(null, count);
                                count++;
                            }
                            System.out.println("Enter the ID of an Airport to edit: ");
                            s = scanner.nextLine();
                            if (isViable(airports.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            ap = airports.get(k);
                            ap.edit();
                            System.out.println("An Airport was edited successfully");
                            break;
                        case "3":
                            count = 0;
                            for(Airport airport : airports) {
                                airport.print(null, count);
                                count++;
                            }
                            System.out.println("Enter the ID of an Airport to delete: ");
                            s = scanner.nextLine();
                            if (isViable(airports.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            ap = airports.get(k);
                            timetables.removeIf(timetable ->
                                    timetable.getRoute().getPlane().getAirport() == ap
                                    || timetable.getRoute().getDestination() == ap);
                            tickets.removeIf(ticket -> ticket.getRoute().getPlane().getAirport() == ap
                                    || ticket.getRoute().getDestination() == ap);
                            routes.removeIf(route -> route.getPlane().getAirport() == ap
                                    || route.getDestination() == ap);
                            planes.removeIf(plane -> plane.getAirport() == ap);
                            airports.remove(k);
                            System.out.println("An Airport was deleted successfully");
                        default:
                            break;
                    }
                    break;
                case "2":
                    Plane p;
                    System.out.print("1 - Create a new Plane, 2 - Edit a Plane, 3 - Delete a Plane, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            p = Plane.create(airports);
                            if (p != null) {
                                planes.add(p);
                                System.out.println("New Plane was added successfully");
                            }
                            break;
                        case "2":
                            count = 0;
                            for (Plane plane : planes) {
                                plane.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Plane to edit: ");
                            s = scanner.nextLine();
                            if (isViable(planes.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            p = planes.get(k);
                            p.edit(airports);
                            System.out.println("A Plane was edited successfully");
                            break;
                        case "3":
                            count = 0;
                            for (Plane plane : planes) {
                                plane.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Plane to delete: ");
                            s = scanner.nextLine();
                            if (isViable(planes.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            Plane plane = planes.get(k);
                            timetables.removeIf(timetable -> timetable.getRoute().getPlane() == plane);
                            tickets.removeIf(ticket -> ticket.getRoute().getPlane() == plane);
                            routes.removeIf(route -> route.getPlane() == plane);
                            planes.remove(k);
                            System.out.println("A Plane was deleted successfully");
                            break;
                        default:
                            break;
                    }
                    break;
                case "3":
                    Route r;
                    System.out.print("1 - Create a new Route, 2 - Edit a Route, 3 - Delete a Route, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            r = Route.create(planes, airports);
                            if (r != null) {
                                routes.add(r);
                                System.out.println("New Route was added successfully");
                            }
                            break;
                        case "2":
                            count = 0;
                            for (Route route : routes) {
                                route.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Route to edit: ");
                            s = scanner.nextLine();
                            if (isViable(routes.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            r = routes.get(k);
                            r.edit(planes, airports);
                            System.out.println("A Route was edited successfully");
                            break;
                        case "3":
                            count = 0;
                            for (Route route : routes) {
                                route.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Route to delete: ");
                            s = scanner.nextLine();
                            if (isViable(routes.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            Route route = routes.get(k);
                            timetables.removeIf(timetable -> timetable.getRoute() == route);
                            tickets.removeIf(ticket -> ticket.getRoute() == route);
                            routes.remove(k);
                            System.out.println("A Route was deleted successfully");
                            break;
                        default:
                            break;
                    }
                    break;
                case "4":
                    Passenger pg;
                    System.out.print("1 - Create a new Passenger, 2 - Edit a Passenger, 3 - Delete a Passenger, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            pg = Passenger.create();
                            if (pg != null) {
                                passengers.add(pg);
                                System.out.println("New Passenger was added successfully");
                            }
                            break;
                        case "2":
                            count = 0;
                            for (Passenger passenger : passengers) {
                                passenger.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Passenger to edit: ");
                            s = scanner.nextLine();
                            if (isViable(passengers.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            pg = passengers.get(k);
                            pg.edit();
                            System.out.println("Passenger was edited successfully");
                            break;
                        case "3":
                            count = 0;
                            for (Passenger passenger : passengers) {
                                passenger.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Passenger to delete: ");
                            s = scanner.nextLine();
                            if (isViable(passengers.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            tickets.removeIf(ticket -> ticket.getPassenger() == passengers.get(k));
                            passengers.remove(k);
                            break;
                        default:
                            break;
                    }
                    break;
                case "5":
                    Timetable tt;
                    System.out.print("1 - Create a new timetable, 2 - Print a timetable, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            tt = Timetable.create(routes);
                            if (tt != null) {
                                timetables.add(tt);
                                System.out.println("New timetable was added successfully");
                            }
                            break;
                        case "2":
                            count = 0;
                            for (Timetable timetable : timetables) {
                                timetable.print(count);
                                count++;
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "6":
                    Ticket tc;
                    double price;
                    System.out.print("1 - Set a new Ticket price, 2 - Sell a Ticket, 3 - Cancel a Ticket, 4 - Revenue, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            System.out.print("Enter the new Ticket price (current price: " + Ticket.getSetPrice() + "): ");
                            try {
                                price = parseDouble(scanner.nextLine());
                            }
                            catch (Exception e) {
                                System.out.println("Error: the value is not a real number");
                                break;
                            }
                            if (price < 0) {
                                System.out.println("Error: the price can't be a negative value");
                                break;
                            }
                            Ticket.setPrice(price);
                            System.out.println("A new Ticket price was set");
                            break;
                        case "2":
                            tc = Ticket.sell(passengers, routes);
                            if (tc != null) {
                                tickets.add(tc);
                                System.out.println("A Ticket was sold successfully");
                            }
                            break;
                        case "3":
                            count = 0;
                            for (Ticket ticket : tickets) {
                                ticket.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Ticket to cancel: ");
                            s = scanner.nextLine();
                            if (isViable(passengers.size(), s)) {
                                k = parseInt(s);
                            }
                            else break;
                            tickets.remove(k);
                            System.out.println("A Ticket was cancelled successfully");
                            break;
                        case "4":
                            double revenue = 0;
                            for (Ticket ticket : tickets) {
                                revenue += ticket.getPrice();
                            }
                            System.out.println("Current revenue: " + revenue);
                        default:
                            break;
                    }
                    break;
                default:
                    return;
            }
        }
    }
}