import java.util.*;

class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> stack = new Stack<>();
    int min;
    public MinStack() {
        stack.clear();
        min = 0;
    }

    public void push(int x) {
        if(!stack.isEmpty()){
            min = this.getMin();
            min = Math.min(x,min);
        }
        else min = x;

        int gap =  x - min;
        stack.push(gap);
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        stack.pop();
        min = this.getMin();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        if(stack.isEmpty()) return 0;
        int cur = stack.pop();
        min = cur - stack.peek();
        stack.push(cur);
        return min;
    }


    public static void main( String[] args){
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   //--> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      //--> Returns 0.
        System.out.println(minStack.getMin());   //--> Returns -2.
        System.out.println(minStack.getMin());   //--> Returns -2.
    }
}