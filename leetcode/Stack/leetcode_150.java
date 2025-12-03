package leetcode.Stack;

import java.util.Stack;

public class leetcode_150 {
    static void main() {
        String[] arr = { "2", "1", "+", "3", "*" };
        System.out.println(evalRPN(arr));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int ans;
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    int b = st.pop();
                    int a = st.pop();
                    ans = (a + b);
                    st.push(ans);
                }
                case "-" -> {
                    int b = st.pop();
                    int a = st.pop();
                    ans = (a - b);
                    st.push(ans);
                }
                case "/" -> {
                    int b = st.pop();
                    int a = st.pop();
                    ans = a / b;
                    st.push(ans);
                }
                case "*" -> {
                    int b = st.pop();
                    int a = st.pop();
                    ans = (a * b);
                    st.push(ans);
                }
                default -> st.push(Integer.parseInt(token));
            }
        }

        return st.pop();
    }
}
