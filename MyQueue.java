// Time Complexity : O(1)
// Space Complexity : O(!)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: I have used two stacks where one stack will act as rear of the queue and other will act as front of the queue


import java.util.Stack;

class MyQueue {
    //two stacks :in_stack will act rear of the queue and out_stack will act as front of queue
    private Stack<Integer> out_stack;
    private Stack<Integer> in_stack;

    //constructor    
    public MyQueue() {
         this.in_stack = new Stack<>();
         this.out_stack = new Stack<>();
    }
    
    public void push(int x) {
        //TC: O(1) SC:O(1)
        //simple pushing in rear
        this.in_stack.push(x);
    }
    
    public int pop() {
        //TC:Amortized O(1) SC:O(1)
        if(out_stack.isEmpty()){
            while(!in_stack.isEmpty()){
                this.out_stack.push(in_stack.pop());
            }
        }
        //pop the element from out stack
        return out_stack.pop();
    }
    public int peek() {
        //TC:Amortized O(1) SC:O(1)
        if(out_stack.isEmpty()){
            while(!in_stack.isEmpty()){
                this.out_stack.push(in_stack.pop());
            }
        }
         // Peek at the front element in out_stack
        return out_stack.peek();
    }
    
    public boolean empty() {
        //TC: O(1) SC:O(1)
        return in_stack.isEmpty() && out_stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */