package T2;

public class Pyramid implements IVShape {
    final double a, b, c, h;

    public Pyramid(double a, double b, double c, double h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    public Pyramid(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.c = 0;
        this.h = h;
    }

    @Override
    public double S() {
        if (c != 0) {
            Triangle t = Triangle.create(a, b, c);
            if (t == null) return - 1;
            double S = t.S();
            double p = (a + b + c) * 0.5;
            double r = S / p;
            double l = Math.sqrt(r * r + h * h);
            return (S + p * l);
        }
        else return (a * b + a * Math.sqrt((b * b) * 0.5 + h * h) + b * Math.sqrt((a * a) * 0.5 + h * h));
    }

    @Override
    public double V() {
        if (c != 0) {
            Triangle t = Triangle.create(a, b, c);
            if (t == null) return - 1;
            return (1 / 3.0 * h * t.S());
        }
        else return (1 / 3.0 * h * a * b);
    }
}
