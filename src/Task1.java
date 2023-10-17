import T1.Stack;

import java.util.Scanner;

public class Task1 {
    public static void stack() {
        Stack<String> stack = new Stack<>();
        while (true) {
            System.out.print("1 - clear, 2 - push, 3 - populate, 4 - print, 5 - size, anything else - exit: ");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            switch (s) {
                case "1":
                    stack = new Stack<>();
                    System.out.println("The stack was cleared successfully");
                    break;
                case "2":
                    System.out.print("Enter the value to push: ");
                    stack.push(scan.nextLine());
                    break;
                case "3":
                    System.out.println("Populated value: " + stack.pop());
                    break;
                case "4":
                    for (String n : stack) {
                        System.out.print(n + " ");
                    }
                    System.out.println();
                    break;
                case "5":
                    System.out.print("Size of the stack: ");
                    int count = 0;
                    for (String ignored : stack) {
                        count++;
                    }
                    System.out.println(count);
                    break;
                default:
                    return;
            }
        }
    }
}
