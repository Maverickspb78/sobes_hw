package HW2;

import java.util.NoSuchElementException;

public class TestLinkedList<T> implements TestList<T> {

    private Node first;
    private Node last;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(T item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    @Override
    public void add(int index, T item) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Wrong index");
        }
        if (index == 0) {
            Node newNode = new Node(item, first);
            first.setPrev(newNode);
            first = newNode;
            size++;
            return;
        }
        int i = 0;
        Node current = first;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        Node newNode = new Node(current.getPrev(), item, current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;

    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        int i = 0;
        Node current = first;
        while (i < index) {
            i++;
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return current.getValue();
    }

    @Override
    public T get(int index) {
        checkIndex(index);

        if (index == 0) {
            return first.getValue();
        }
        if (index == size - 1) {
            return last.getValue();
        }
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        return current.getValue();
    }

    @Override
    public boolean remove(Object item) {
        if (isEmpty()) {
            return false;
        }
        if (first.value.equals(item)) {
            removeFirst();
            return true;
        }

        Node current = first;
        while (current != null && !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }

        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int indexOf(T item) {
        Node current = first;
        int index = 0;
        while (current != null) {
            if (current.value.equals(item)) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);

        if (index == 0) {
            first.setValue(item);
        }
        if (index == size - 1) {
            last.setValue(item);
        }
        Node current = first;
        int i = 0;
        while (i < index) {
            current = current.getNext();
            i++;
        }
        current.setValue(item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node next = first;
        while (next != null) {
            sb.append(next.getValue()).append(", ");
            next = next.getNext();
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

    private class Node {
        Node prev;
        T value;
        Node next;

        public Node(Node prev, T value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrev() {
            return prev;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }

    private T removeFirst() {
        T temp = getFirst();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrev(null);
        }
        size--;
        return temp;
    }

    private T removeLast() {
        T temp = getLast();
        if (last.getPrev() == null) {
            first = null;
        } else {
            last.getPrev().setNext(null);
        }
        last = last.getPrev();
        size--;
        return temp;
    }

    private T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return first.value;
    }

    private T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        return last.value;
    }

    private void checkIndex(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException("Empty");
        }
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Wrong index");
        }
    }
}
