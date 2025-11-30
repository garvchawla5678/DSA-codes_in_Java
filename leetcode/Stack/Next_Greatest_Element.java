package leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class Next_Greatest_Element {
    static void main() {
        int[] arr = { 55, 11, 9, 7, 13, 3, 66, 60 };
        System.out.println(Arrays.toString(solution(arr)));
    }

    static int[] solution(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                ans[st.pop()] = arr[i];
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }
        return ans;
    }
}
