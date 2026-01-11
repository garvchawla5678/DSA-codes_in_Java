package Recursion;

import java.util.Stack;

public class ReverseStack {
    static void main() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println("Original stack: " + stack);
        reverse(stack);
        System.out.println("Reversed stack: " + stack);
    }
    static void reverse(Stack<Integer> st) {
        // 1st approach   T.C: O(n), S.C: O(n)
        // if(st.isEmpty()) return;

        // int top = st.pop();
        // reverse(st);
        // Stack<Integer> temp = new Stack<>();
        // while(!st.isEmpty()) {
        //     temp.push(st.pop());
        // }
        // st.push(top);
        // while(!temp.isEmpty()) {
        //     st.push(temp.pop());
        // }

        // 2nd approach  T.C: O(n^2), S.C: O(1)
        if(st.isEmpty()) return;

        int top = st.pop();
        reverse(st);
        insertAtBottom(st,top);
    }
    static void insertAtBottom(Stack<Integer> st, int element) {
        if(st.isEmpty()) {
            st.push(element);
            return;
        }
        int top = st.pop();
        insertAtBottom(st,element);
        st.push(top);
    }
}
