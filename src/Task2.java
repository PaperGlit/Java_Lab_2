import T2.*;

import java.util.Scanner;

public class Task2 {
    public static void shapes() {
        while (true) {
            double a, b, c, h;
            System.out.print("""
                    Select the desired shape:\s
                    1 - triangle, 2 - rectangle, 3 - square, 4 - circle,\s
                    5 - cube,  6 - pyramid, 7 - sphere, anything else - exit:\s""");
            Scanner scan  = new Scanner(System.in);
            String k = scan.nextLine();

            switch (k) {
                case "1":
                    System.out.print("Enter the triangle's length #1: ");
                    a = Shape.parser(scan.nextLine());
                    if (a == -1) break;
                    System.out.print("Enter the triangle's length #2: ");
                    b = Shape.parser(scan.nextLine());
                    if (b == -1) break;
                    System.out.print("Enter the triangle's length #3: ");
                    c = Shape.parser(scan.nextLine());
                    if (c == -1) break;
                    Triangle t = Triangle.create(a, b, c);
                    if (t == null) break;
                    System.out.println("Area: " + t.S());
                    break;
                case "2":
                    System.out.print("Enter the rectangle's length: ");
                    a = Shape.parser(scan.nextLine());
                    if (a == -1) break;
                    System.out.print("Enter the rectangle's width: ");
                    b = Shape.parser(scan.nextLine());
                    if (b == -1) break;
                    Rectangle r = new Rectangle(a, b);
                    System.out.println("Area: " + r.S());
                    break;
                case "3":
                    System.out.print("Enter the square's length: ");
                    a = Shape.parser(scan.nextLine());
                    if (a == -1) break;
                    Square s = new Square(a);
                    System.out.println("Area: " + s.S());
                    break;
                case "4":
                    System.out.print("Enter the circle's radius: ");
                    a = Shape.parser(scan.nextLine());
                    if (a == -1) break;
                    Circle cl = new Circle(a);
                    System.out.println("Area: " + cl.S());
                    break;
                case "5":
                    System.out.print("Enter the cube's length: ");
                    a = Shape.parser(scan.nextLine());
                    if (a == -1) break;
                    Cube cb = new Cube(a);
                    System.out.println("Area: " + cb.S() + "\nVolume: " + cb.V());
                    break;
                case "6":
                    System.out.print("1 - Triangular pyramid, 2 - Rectangular pyramid, anything else - return: ");
                    k = scan.nextLine();
                    Pyramid pm;
                    switch (k) {
                        case "1":
                            System.out.print("Enter the pyramid's base length #1: ");
                            a = Shape.parser(scan.nextLine());
                            if (a == -1) break;
                            System.out.print("Enter the pyramid's base length #2: ");
                            b = Shape.parser(scan.nextLine());
                            if (b == -1) break;
                            System.out.print("Enter the pyramid's base length #3: ");
                            c = Shape.parser(scan.nextLine());
                            if (c == -1) break;
                            System.out.print("Enter the pyramid's height: ");
                            h = Shape.parser(scan.nextLine());
                            if (h == -1) break;
                            pm = new Pyramid(a, b, c, h);
                            if (pm.S() == -1 || pm.V() == -1) break;
                            System.out.println("Area: " + pm.S() + "\nVolume: " + pm.V());
                            break;
                        case "2":
                            System.out.print("Enter the pyramid's base length: ");
                            a = Shape.parser(scan.nextLine());
                            if (a == -1) break;
                            System.out.print("Enter the pyramid's base width: ");
                            b = Shape.parser(scan.nextLine());
                            if (b == -1) break;
                            System.out.print("Enter the pyramid's height: ");
                            h = Shape.parser(scan.nextLine());
                            if (h == -1) break;
                            pm = new Pyramid(a, b, h);
                            System.out.println("Area: " + pm.S() + "\nVolume: " + pm.V());
                            break;
                        default:
                            break;
                    }
                    break;
                case "7":
                    System.out.print("Enter the sphere's radius: ");
                    a = Shape.parser(scan.nextLine());
                    if (a == -1) break;
                    Sphere sp = new Sphere(a);
                    System.out.println("Area: " + sp.S() + "\nVolume: " + sp.V());
                    break;
                default:
                    return;
            }
        }
    }
}
