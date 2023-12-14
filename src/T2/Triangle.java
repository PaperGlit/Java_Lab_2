package T2;

public class Triangle implements IShape {
    final double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static Triangle create(double a, double b, double c) {
        if (a + b < c || b + c < a || c + a < b) {
            System.out.println("Error: this triangle cannot exist");
            return null;
        }
        return new Triangle(a, b, c);
    }

    @Override
    public double S() {
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
