import java.util.Stack;

class MinStack {
    private Stack<Integer> values;
    private Stack<Integer> minimums;

    public MinStack() {
        values = new Stack<>();
        minimums = new Stack<>();
    }

    public void push(int val) {
        values.push(val);

        if (minimums.isEmpty() || val <= minimums.peek()) {
            minimums.push(val);
        }
    }

    public void pop() {
        int removed = values.pop();

        if (removed == minimums.peek()) {
            minimums.pop();
        }
    }

    public int top() {
        return values.peek();
    }

    public int getMin() {
        return minimums.peek();
    }
}
