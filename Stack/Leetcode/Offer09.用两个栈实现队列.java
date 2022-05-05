class CQueue {
    Stack<Integer> stack_in;
    Stack<Integer> stack_out;
    public CQueue() {
        stack_in = new Stack();
        stack_out = new Stack();
    }

    public void appendTail(int value) {
        stack_in.push(value);
    }

    public int deleteHead() {
        if(stack_out.isEmpty()) {
            while(!stack_in.isEmpty()) {
                stack_out.push(stack_in.pop());
            }
        }
        if(!stack_out.isEmpty()){
            return stack_out.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */