package T2;

public class Circle implements IShape {
    double a;

    public Circle(double a) {
        this.a = a;
    }

    @Override
    public double S() {
        return Math.PI * a * a;
    }
}
