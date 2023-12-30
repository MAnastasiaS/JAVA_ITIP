import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Stack<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public Stack() {
        this.data = (T[]) new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            data = Arrays.copyOf(data, 2 * size);
        }
        data[size++] = element;
    }

    public T pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        T element = data[--size];
        data[size] = null; // Prevent memory leak
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return data[size - 1];
    }
}
