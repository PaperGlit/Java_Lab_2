import java.util.Scanner;

abstract class Shape {
    public abstract double S();
}
abstract class VShape extends Shape {
    @Override
    public abstract double S();
    public abstract double V();
}
class Triangle extends Shape {
    double a, b, c;
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public double S(){
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
class Rectangle extends Shape {
    double a, b;
    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }
    @Override
    public double S() {
        return a * b;
    }
}
class Square extends Shape {
    double a;
    public Square(double a) {
        this.a = a;
    }
    @Override
    public double S() {
        return a * a;
    }
}
class Circle extends Shape {
    double a;
    public Circle(double a) {
        this.a = a;
    }
    @Override
    public double S() {
        return Math.PI * a * a;
    }
}
class Cube extends VShape {
    double a;
    public Cube(double a) {
        this.a = a;
    }
    @Override
    public double S() {
        return 6 * a * a;
    }
    @Override
    public double V() {
        return a * a * a;
    }
}
class Pyramid extends VShape {
    double a;
    public Pyramid(double a) {
        this.a = a;
    }
    @Override
    public double S() {
        return (a * a) + (4 * ((Math.sqrt(3)/4)) * a * a);
    }
    @Override
    public double V() {
        return (1 / 3.0) * a * a * (1 / 2.0) * Math.sqrt(2);
    }
}
class Sphere extends VShape {
    double a;
    public Sphere(double a) {
        this.a = a;
    }
    @Override
    public double S() {
        return 4 * Math.PI * a * a;
    }
    @Override
    public double V(){
        return 4 / 3.0 * Math.PI * a * a * a;
    }
}
public class Task2 {
    public static void shapes() {
        while (true) {
            double a = 0, b = 0, c = 0;
            System.out.print("""
                    Select the desired shape:\s
                    1 - triangle, 2 - rectangle, 3 - square, 4 - circle,\s
                    5 - cube,  6 - pyramid, 7 - sphere, anything else - exit:\s""");
            Scanner scan  = new Scanner(System.in);
            String k = scan.nextLine();

            switch (k) {
                case "1":
                 System.out.print("Enter the triangle's value #1: ");
                    a = Double.parseDouble(scan.nextLine());
                    System.out.print("Enter the triangle's value #2: ");
                    b = Double.parseDouble(scan.nextLine());
                    System.out.print("Enter the triangle's value #3: ");
                    c = Double.parseDouble(scan.nextLine());
                    Triangle t = new Triangle(a, b, c);
                    System.out.println("Area: " + t.S());
                    break;
                case "2":
                    System.out.print("Enter the rectangle's value #1: ");
                    a = Double.parseDouble(scan.nextLine());
                    System.out.print("Enter the rectangle's value #2: ");
                    b = Double.parseDouble(scan.nextLine());
                    Rectangle r = new Rectangle(a, b);
                    System.out.println("Area: " + r.S());
                    break;
                case "3":
                    System.out.print("Enter the square's value: ");
                    a = Double.parseDouble(scan.nextLine());
                    Square s = new Square(a);
                    System.out.println("Area: " + s.S());
                    break;
                case "4":
                    System.out.print("Enter the circle's value: ");
                    a = Double.parseDouble(scan.nextLine());
                    Circle cl = new Circle(a);
                    System.out.println("Area: " + cl.S());
                    break;
                case "5":
                    System.out.print("Enter the cube's value: ");
                    a = Double.parseDouble(scan.nextLine());
                    Cube cb = new Cube(a);
                    System.out.println("Area: " + cb.S() + "\nVolume: " + cb.V());
                    break;
                case "6":
                    System.out.print("Enter the pyramid's value: ");
                    a = Double.parseDouble(scan.nextLine());
                    Pyramid p = new Pyramid(a);
                    System.out.println("Area: " + p.S() + "\nVolume: " + p.V());
                    break;
                case "7":
                    System.out.print("Enter the sphere's value: ");
                    a = Double.parseDouble(scan.nextLine());
                    Sphere sp = new Sphere(a);
                    System.out.println("Area: " + sp.S() + "\nVolume: " + sp.V());
                    break;
                default:
                    return;
            }
        }
    }
}
