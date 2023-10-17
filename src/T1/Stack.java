package T1;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
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
