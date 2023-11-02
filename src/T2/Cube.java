package T2;

public class Cube implements IVShape {
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
