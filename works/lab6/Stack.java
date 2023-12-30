public class Stack<T> {
    private T data[];
    private int size;

    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) { // добавление элемента в стек
        data[size] = element;
        size++;
    }
    public T pop() { // удаление элемента из стека
        T element = data[size - 1];
        data[size - 1] = null;
        size--;
        return element;
    }
    public T peek() { // получение первого верхнего стека без его удаления
        return data[size - 1];
    }
}
