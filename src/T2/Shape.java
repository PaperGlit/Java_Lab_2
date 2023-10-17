package T2;

import static java.lang.Double.parseDouble;

public interface Shape {
    @SuppressWarnings("unused")
    default double S() {
        return 0;
    }
    static double parser(String s) {
        double value;
        try {
            value = parseDouble(s);
        }
        catch (Exception e) {
            System.out.println("Error: invalid value");
            return -1;
        }
        if (value <= 0) {
            System.out.println("Error: value can't be negative nor be equal to zero");
            return -1;
        }
        return value;
    }
}
