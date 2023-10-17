package T2;

public class Square implements Shape {
    double a;

    public Square(double a) {
        this.a = a;
    }

    @Override
    public double S() {
        return a * a;
    }
}
