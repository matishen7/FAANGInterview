package Udemy.InterfaceDesign;

import java.util.Stack;

public class CustomStack {
    private int maxSize;
    Stack<Integer> stack;

    public CustomStack(int maxSize) {
        stack = new Stack<>();
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (stack.size() < maxSize) stack.push(x);
    }

    public int pop() {
        if (!stack.isEmpty()) return stack.pop();
        else return -1;
    }

    public void increment(int k, int val) {
        Stack<Integer> temp = new Stack<>();
        int i = 0;
        while (!stack.isEmpty())
            temp.add(stack.pop());
        while (i < k)
        {
            if (temp.isEmpty()) break;
            int value = temp.pop() + val;
            stack.add(value);
            i++;
        }
        while (!temp.isEmpty())
            stack.add(temp.pop());
    }
    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // Stack is Empty []
        customStack.push(1);                          // stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
        customStack.push(2);                          // stack becomes [1, 2]
        customStack.push(3);                          // stack becomes [1, 2, 3]
        customStack.push(4);                          // stack still [1, 2, 3], Don't add another elements as size is 4
        customStack.increment(5, 100);                // stack becomes [101, 102, 103]
        customStack.increment(2, 100);                // stack becomes [201, 202, 103]
        System.out.println(customStack.pop());                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
        System.out.println(customStack.pop());                            // return 202 --> Return top of the stack 102, stack becomes [201]
        System.out.println(customStack.pop());                            // return 201 --> Return top of the stack 101, stack becomes []
        System.out.println(customStack.pop());
    }
}
