package leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_739 {
    static void main() {
        int[] arr = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(dailyTemperatures(arr)));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
                ans[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        return ans;
    }
}
