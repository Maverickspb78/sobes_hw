package HW2;

import java.util.Arrays;

public class TestArrayList<T> implements TestList<T> {
    private final int DEFAULT_CAPACITY = 10;
    private final float FILLFACTOR = 0.8f;
    private int size;
    private int capacity;
    private T[] arrayList;

    public TestArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        arrayList = (T[]) new Object[capacity];
    }

    public TestArrayList(int capacity) {
        if (capacity<= 0){
            throw new IllegalArgumentException("wrong capacity: capacity <= 0 ");
        }
        this.capacity = capacity;
        arrayList = (T[]) new Object[capacity];
    }

    private boolean checkIndex(int index) {
        return index < size;
    }

    private void checkLoadFactor(int size) {
        if (size > (capacity * FILLFACTOR)) {
            capacity *= 2;
            T[] newArray = (T[]) new Comparable[capacity];
            System.arraycopy(arrayList, 0, newArray, 0, arrayList.length);
            arrayList = newArray;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(Object item) {
        checkLoadFactor(size);
        arrayList[size] = (T) item;
        size++;

    }

    @Override
    public void add(int index, T item) throws ArrayIndexOutOfBoundsException{
        checkLoadFactor(size);
        if (!checkIndex(index)) throw  new ArrayIndexOutOfBoundsException();
        for (int i = size; i > index; i--) {
            arrayList[i] = arrayList[i - 1];
        }
        arrayList[index] = item;
        size++;

    }

    @Override
    public T remove(int index) throws ArrayIndexOutOfBoundsException{
        if (!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
        T tempItem = arrayList[index];
        for (int i = index; i < size; i++) {
            arrayList[i] = arrayList[i + 1];
        }
        size--;
        arrayList[size] = null;
        return tempItem;
    }

    @Override
    public T get(int index) throws ArrayIndexOutOfBoundsException {
        if (!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
        return arrayList[index];
    }

    @Override
    public boolean remove(T item) {
        int i = indexOf(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void set(int index, T item) throws ArrayIndexOutOfBoundsException {
        if (!checkIndex(index)) throw new ArrayIndexOutOfBoundsException();
        arrayList[index] = item;

    }

    @Override
    public String toString() {
        return "TestArrayList{" +
                ", arrayList=" + Arrays.toString(arrayList) +
                '}';
    }
}
