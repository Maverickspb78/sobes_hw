package HW2;

public interface TestList<T> {

    int size();

    void add(T item);

    void add(int index, T item);

    T remove(int index);

    T get(int index);

    boolean remove(T item);

    boolean isEmpty();

    int indexOf(T item);

    void set(int index, T item);

}
