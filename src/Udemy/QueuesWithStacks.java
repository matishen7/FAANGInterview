package Udemy;

import java.util.Stack;

public class QueuesWithStacks {
    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        System.out.println(myQueue);
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue);
        myQueue.peek(); // return 1
        System.out.println(myQueue);
        myQueue.pop(); // return 1, queue is [2]
        System.out.println(myQueue);
        myQueue.empty(); // return false
        System.out.println(myQueue);
    }

    public static class MyQueue
    {
        private Stack<Integer> in;
        private Stack<Integer> out;

        public MyQueue(){
            in = new Stack<>();
            out = new Stack<>();
        };
        public void push(int x) {
            in.push(x);
        }

        public int pop() {
            if (this.out.size() == 0) {
                while(this.in.size() > 0) {
                    this.out.push(this.in.pop());
                }
            }
            return this.out.pop();
        }

        public int peek() {
            if (this.out.size() == 0) {
                while(this.in.size() > 0) {
                    this.out.push(this.in.pop());
                }
            }

            return this.out.get(this.out.size() - 1);
        }

        public boolean empty() {
            return this.in.size() == 0 && this.out.size() == 0;
        }

        public void PrintQueue()
        {

        }

    }

}
