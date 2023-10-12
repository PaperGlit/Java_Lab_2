import java.util.Scanner;

import static java.lang.Integer.parseInt;

class Stack<T> {
    static class Node<T> {
        T info;
        Node<T> next;

        public Node(T info) {
            this.info = info;
            this.next = null;
        }
    }

    private Node<T> end;

    public Stack() {
        this.end = null;
    }

    public void push(T info) {
        Node<T> newNode = new Node<>(info);
        newNode.next = end;
        end = newNode;
    }

    public T pop() {
        if (end == null) {
            System.out.println("Error: the stack is empty");
            return null;
        }
        T data = end.info;
        end = end.next;
        return data;
    }

    public int size() {
        int count = 0;
        Node<T> current = end;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void print() {
        Node<T> current = end;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }
}

public class Task1 {
    public static void stack() {
        Stack<Integer> stack = new Stack<>();
        while (true) {
            System.out.print("1 - create a new stack, 2 - push, 3 - populate, 4 - print, 5 - size, anything else - exit: ");
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            switch (s) {
                case "1":
                    stack = new Stack<>();
                    break;
                case "2":
                    System.out.print("Enter an integer to push: ");
                    int i = parseInt(scan.nextLine());
                    stack.push(i);
                    break;
                case "3":
                    System.out.println("Populated integer: " + stack.pop());
                    break;
                case "4":
                    stack.print();
                    break;
                case "5":
                    System.out.println("Size of the stack: " + stack.size());
                    break;
                default:
                    return;
            }
        }
    }
}
