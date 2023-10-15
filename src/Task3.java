import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.Character.isDigit;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class Airport {
    String name;
    String location;
    public Airport (String name, String location) {
        this.name = name;
        this.location = location;
    }
    public static Airport create () {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of an Airport: ");
        String s = scanner.nextLine();
        System.out.print("Enter the location of an Airport: ");
        String t = scanner.nextLine();
        return new Airport(s, t);
    }
    public void print(int count) {
        System.out.println("#" + count + " " + this.name + " (" + this.location + ")");
    }
}
class Plane {
    String name;
    Airport location;
    public Plane (String name, Airport location) {
        this.name = name;
        this.location = location;
    }
    public static Plane create (ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of a new Plane: ");
        String s = scanner.nextLine();
        int count = 0;
        int k;
        for(Airport airport : airports) {
            airport.print(count);
            count++;
        }
        System.out.print("Enter the ID of the location of a new Plane: ");
        if (Task3.isViable(airports.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        }
        else return null;
        return new Plane(s, airports.get(k));
    }
    public void print(int count) {
        System.out.println("#" + count + " " + this.name + " (" + this.location.name + "(" + this.location.location + "))");
    }
}
class Route {
    Plane plane;
    Airport destination;
    String timeD;
    String timeA;
    public Route (Plane plane, Airport destination, String timeD, String timeA) {
        this.plane = plane;
        this.destination = destination;
        this.timeD = timeD;
        this.timeA = timeA;
    }
    public static Route create (ArrayList<Plane> planes, ArrayList<Airport> airports) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int j, k;
        String s, t;
        for (Plane plane : planes) {
            plane.print(count);
            count++;
        }
        System.out.print("Select the ID of the plane for this route: ");
        if (Task3.isViable(planes.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        }
        else return null;
        count = 0;
        for (Airport airport : airports) {
            airport.print(count);
            count++;
        }
        System.out.print("Select the ID of the airport for the destination of this route: ");
        if (Task3.isViable(airports.size(), scanner.nextLine())) {
            j = parseInt(scanner.nextLine());
        }
        else return null;
        System.out.print("Select the time of departure for this route (HH:MM 24-hour format): ");
        if (Task3.isTime(scanner.nextLine())) {
            s = scanner.nextLine();
        }
        else return null;
        System.out.print("Select the time of arrival for this route (HH:MM 24-hour format): ");
        if (Task3.isTime(scanner.nextLine())) {
            t = scanner.nextLine();
        }
        else return null;
        return new Route(planes.get(k), airports.get(j), s, t);
    }
    public void print (int count) {
        System.out.println("#" + count + " " + this.timeD + " - " + this.timeA + " " +
                this.plane.location.location + " - " + this.destination.location +
                " (" + this.plane.name + ")");
    }
}
class Passenger {
    String name;
    int age;

    public Passenger (String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static Passenger create (ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int j, k;
        String s;
        System.out.print("Enter the name of a Passenger: ");
        s = scanner.nextLine();
        System.out.print("Enter the age of a Passenger: ");
        try {
            k = parseInt(scanner.nextLine());
        }
        catch (Exception e) {
            System.out.println("Error: the value is not an integer");
            return null;
        }

        return new Passenger(s, k);
    }
    public void print(int count) {
        System.out.println("#" + count + " " + this.name + " (" + this.age + ")");
    }
}
class Timetable {
    Route route;
    String schedule;
    public Timetable (Route route, String schedule) {
        this.route = route;
        this.schedule = schedule;
    }
    public static Timetable create (ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int k;
        String s;
        for (Route route : routes) {
            route.print(count);
            count++;
        }
        System.out.print("Select the ID of the route for this Timetable: ");
        if (Task3.isViable(routes.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        }
        else return null;
        System.out.print("Enter the schedule for this route (f.e. Tue-Sat): ");
        s = scanner.nextLine();
        return new Timetable(routes.get(k), s);
    }
    public void print (int count) {
        System.out.println("#" + count + " (" + this.route.timeD + " - " + this.route.timeA + " " + this.schedule + ") "
                + this.route.plane.location.location + " - " + this.route.destination.location);
    }
}
class Ticket {
    static double p = 100;
    double price;
    Passenger passenger;
    Route route;
    public Ticket (Passenger passenger, Route route) {
        this.price = p;
        this.passenger = passenger;
        this.route = route;
    }
    public static void setPrice (double p) {
        Ticket.p = p;
    }
    public static Ticket sell(ArrayList<Passenger> passengers, ArrayList<Route> routes) {
        Scanner scanner = new Scanner(System.in);
        String s;
        int count = 0;
        int j, k;
        for (Passenger passenger : passengers) {
            passenger.print(count);
            count++;
        }
        System.out.print("Select the ID of the passenger for this Ticket: ");
        if (Task3.isViable(passengers.size(), scanner.nextLine())) {
            k = parseInt(scanner.nextLine());
        }
        else return null;
        count = 0;
        for (Route route : routes) {
            route.print(count);
            count++;
        }
        System.out.print("Select the ID of the route for this Ticket: ");
        if (Task3.isViable(routes.size(), scanner.nextLine())) {
            j = parseInt(scanner.nextLine());
        }
        else return null;
        return new Ticket(passengers.get(k), routes.get(j));
    }
}

public class Task3 {
    static boolean isViable (int size, String s) {
        int k;
        try {
            k = parseInt(s);
        }
        catch (Exception e) {
            System.out.println("Error: non-integer value detected");
            return false;
        }
        if (k < 0 || k > size) {
            System.out.println("Error: the value is out-of-reach");
            return false;
        }
        return true;
    }
    static boolean isTime(String s) {
        if (s.length() != 5) {
            System.out.println("Error: incorrect time format detected");
            return false;
        }
        for (int i = 0 ; i < 5 ; i++) {
            if (!(isDigit(s.charAt(i)) || (s.charAt(i) == ':' && i == 2))) {
                System.out.println("Error: incorrect time format detected");
                return false;
            }
        }
        return true;
    }
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
            String t;
            int j, k, count;
            switch (s) {
                case "1":
                    System.out.print("1 - Create a new Airport, 2 - Edit an Airport, 3 - Delete an Airport, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            airports.add(Airport.create());
                            System.out.println("New Airport was added successfully");
                            break;
                        case "2":
                            count = 0;
                            for(Airport airport : airports) {
                                airport.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of an Airport to edit: ");
                            if (isViable(airports.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            airports.set(k, Airport.create());
                            System.out.println("An Airport was edited successfully");
                            break;
                        case "3":
                            count = 0;
                            for(Airport airport : airports) {
                                airport.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of an Airport to delete: ");
                            if (isViable(airports.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            airports.remove(k);
                            System.out.println("An Airport was deleted successfully");
                        default:
                            break;
                    }
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
                            if (isViable(planes.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            p = Plane.create(airports);
                            if (p != null) {
                                planes.set(k, p);
                                System.out.println("A Plane was edited successfully");
                            }
                            break;
                        case "3":
                            count = 0;
                            for (Plane plane : planes) {
                                plane.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Plane to delete: ");
                            if (isViable(planes.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            planes.remove(k);
                            System.out.println("A Plane was deleted successfully");
                            break;
                        default:
                            break;
                    }
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
                            if (isViable(routes.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            r = Route.create(planes, airports);
                            if (r != null) {
                                routes.set(k, r);
                                System.out.println("A Route was edited successfully");
                            }
                            break;
                        case "3":
                            count = 0;
                            for (Route route : routes) {
                                route.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Route to delete: ");
                            if (isViable(routes.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            routes.remove(k);
                            System.out.println("A Route was deleted successfully");
                            break;
                        default:
                            break;
                    }
                case "4":
                    Passenger pg;
                    System.out.print("1 - Create a new Passenger, 2 - Edit a Passenger, 3 - Delete a Passenger, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            pg = Passenger.create(routes);
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
                            if (isViable(passengers.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            pg = Passenger.create(routes);
                            if (pg != null) {
                                passengers.set(k, pg);
                                System.out.println("Passenger was edited successfully");
                            }
                            break;
                        case "3":
                            count = 0;
                            for (Passenger passenger : passengers) {
                                passenger.print(count);
                                count++;
                            }
                            System.out.println("Enter the ID of a Passenger to delete: ");
                            if (isViable(passengers.size(), scanner.nextLine())) {
                                k = parseInt(scanner.nextLine());
                            }
                            else break;
                            passengers.remove(k);
                            break;
                        default:
                            break;
                    }
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
                case "6":
                    Ticket tc;
                    double price;
                    System.out.print("1 - Set a new ticket price, 2 - Sell a ticket, 3 - Revenue, anything else - return: ");
                    s = scanner.nextLine();
                    switch (s) {
                        case "1":
                            System.out.print("Enter the new ticket price: ");
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
                            System.out.println("A new ticket price was set");
                            break;
                        case "2":
                            tc = Ticket.sell(passengers, routes);
                            if (tc != null) {
                                tickets.add(tc);
                                System.out.println("A Ticket was sold successfully");
                            }
                            break;
                        case "3":
                            double revenue = 0;
                            for (Ticket ticket : tickets) {
                                revenue += ticket.price;
                            }
                            System.out.println("Current revenue: " + revenue);
                        default:
                            break;
                    }
                default:
                    return;
            }
        }
    }
}
