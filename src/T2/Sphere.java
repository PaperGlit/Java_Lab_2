package T2;

public class Sphere implements IVShape {
    double a;

    public Sphere(double a) {
        this.a = a;
    }

    @Override
    public double S() {
        return 4 * Math.PI * a * a;
    }

    @Override
    public double V() {
        return 4 / 3.0 * Math.PI * a * a * a;
    }
}
