package leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Stock_Plan {
    static void main() {
        int[] arr = { 30, 35, 40, 38, 35 ,44 };
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] solution(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            ans[i]++;
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                ans[i] += ans[st.pop()];
            }
            st.push(i);
        }
        return ans;
    }
}
