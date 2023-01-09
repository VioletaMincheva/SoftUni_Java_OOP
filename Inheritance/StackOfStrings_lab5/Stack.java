package Inheritance.StackOfStrings_lab5;

import java.util.ArrayList;

public class Stack {
    private ArrayList<String> data;

    public Stack() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        data.add(item);
    }

    public String pop() {
        if (isEmpty()) {
            return null;
        }
        return data.remove(this.data.size() - 1);

    }

    public String peek() {
        if (isEmpty()) {
            return null;
        }
        return data.get(this.data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }
}
