package T3;

import static java.lang.Character.isDigit;
import static java.lang.Integer.parseInt;

public class Additions {
    public static boolean isViable (int size, String s) {
        int k;
        try {
            k = parseInt(s);
        }
        catch (Exception e) {
            System.out.println("Error: non-integer value detected");
            return false;
        }
        if (k < 0 || k > size) {
            System.out.println("Error: the value is out-of-reach");
            return false;
        }
        return true;
    }
    public static boolean isTime(String s) {
        if (s.length() != 5) {
            System.out.println("Error: incorrect time format detected");
            return false;
        }
        for (int i = 0 ; i < 5 ; i++) {
            if (!(isDigit(s.charAt(i)) || (s.charAt(i) == ':' && i == 2))) {
                System.out.println("Error: incorrect time format detected");
                return false;
            }
        }
        return true;
    }
}