import java.util.Scanner;
import java.util.Iterator;

class Stack<T> implements Iterable<T> {
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
    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private Node<T> current = end;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new java.util.NoSuchElementException();
                }
                T data = current.info;
                current = current.next;
                return data;
            }
        };
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
}

public class Task1 {
    public static void stack() {
        Stack<String> stack = new Stack<>();
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
                    stack.push(scan.nextLine());
                    break;
                case "3":
                    System.out.println("Populated integer: " + stack.pop());
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
