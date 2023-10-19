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
        int t, u;
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
        t = parseInt(s.substring(0, 2));
        u = parseInt(s.substring(3));
        if (t < 0 || t > 24 || u < 0 || u > 24 ) {
            System.out.println("Error: incorrect time format detected");
            return false;
        }
        return true;
    }

    private static boolean isFirstLetterOfDay(char c) {
        return (c == 'M' || c == 'T' || c == 'W' || c == 'F' || c == 'S');
    }

    private static boolean isLastLetterOfDay(char c) {
        return (c == 'n' || c == 'e' || c == 'd' || c == 'u' || c == 'i' || c == 't');
    }

    //Viable formats: (DDD-DDD; DDD - DDD; DDD, DDD, DDD, ..., DDD; DDD,DDD,DDD,...,DDD)
    public static boolean isDate(String s) {
        char c, cm1, cp1;
        int ip3;
        boolean alreadyHasDash = false, isCorrectDay = false;
        StringBuilder sb = new StringBuilder();
        String[] dates = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (i == 0) cm1 = 0;
            else cm1 = s.charAt(i - 1);
            if (i == s.length() - 1) cp1 = 0;
            else cp1 = s.charAt(i + 1);
            if (c == '-') {
                if (alreadyHasDash) return false;
                else alreadyHasDash = true;
            } else if (c == ',' && alreadyHasDash) return false;
            if (c == '-' && !((isLastLetterOfDay(cm1) || cm1 == ' ')
                    && (isFirstLetterOfDay(cp1) || cp1 == ' '))) {
                return false;
            } else if (c == ',' && !(isLastLetterOfDay(cm1)
                    && (isLastLetterOfDay(cp1) || cp1 == ' '))) {
                return false;
            }
            if (isFirstLetterOfDay(c)) {
                ip3 = i + 3;
                while (i < ip3) {
                    sb.append(s.charAt(i));
                    i++;
                }
                for (String date : dates) {
                    if (sb.toString().equals(date)) {
                        isCorrectDay = true;
                        break;
                    }
                }
                if (!isCorrectDay) return false;
            }
        }
        return true;
    }
}
