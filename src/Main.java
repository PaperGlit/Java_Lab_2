import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("1 - Task 1, 2 - Task 2, 3 - Task 3, anything else - exit: ");
            String s = scanner.nextLine();
            switch (s) {
                case "1":
                    Task1.stack();
                    break;
                case "2":
                    Task2.shapes();
                    break;
                case "3":
                    Task3.airport();
                    break;
                default:
                    return;
            }
        }
    }
}