class MinStack {
    Stack<Integer> stack;
    Stack<Integer> min_stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack();
        min_stack = new Stack();
        min_stack.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        min_stack.push((Math.min(min_stack.peek(),x)));
    }

    public void pop() {
        stack.pop();
        min_stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min_stack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
//如果最小元素恰巧被弹出，那么最小值如何更新

//辅助栈可以与插入删除操作同时压入或弹出最小值