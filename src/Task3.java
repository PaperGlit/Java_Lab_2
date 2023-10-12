class Plane {
    String name;
    String location;
    public Plane (String name, String location) {
        this.name = name;
        this.location = location;
    }
    public void edit (String name, String location) {
        this.name = name;
        this.location = location;
    }
}
class Route {
    Plane plane;
    Airport origin;
    Airport destination;
    String timeD;
    String timeA;
    int price;
    public Route (Plane plane, Airport origin, Airport destination, String timeD, String timeA, int price) {
        this.plane = plane;
        this.origin = origin;
        this.destination = destination;
        this.timeD = timeD;
        this.timeA = timeA;
        this.price = price;
    }
    public void edit (Plane plane, Airport origin, Airport destination, String timeD, String timeA, int price) {
        this.plane = plane;
        this.origin = origin;
        this.destination = destination;
        this.timeD = timeD;
        this.timeA = timeA;
        this.price = price;
    }
    public int getPrice () {return this.price;}
}
class Passenger {
    String name;
    int age;
    Route route;
    public Passenger (String name, int age, Route route) {
        this.name = name;
        this.age = age;
        this.route = route;
    }
    public void edit (String name, int age, Route route) {
        this.name = name;
        this.age = age;
        this.route = route;
    }
    public Ticket buyTicket () {
        return new Ticket(this.route.getPrice(), this.route);
    }
}
class Airport {
    String name;
    String location;
    public Airport (String name, String location) {
        this.name = name;
        this.location = location;
    }
    public void edit (String name, String location) {
        this.name = name;
        this.location = location;
    }
}
class Ticket {
    int price;
    Route route;
    public Ticket (int price, Route route) {
        this.price = price;
        this.route = route;
    }
}
public class Task3 {
    public static void airport() {
        while (true) {
            System.out.print("1 - ");
        }
    }
}
