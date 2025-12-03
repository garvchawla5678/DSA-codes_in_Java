package leetcode.Stack;

import java.util.Arrays;
import java.util.Stack;

public class leetcode_503 {
    static void main() {
        int[] arr = { 1, 2, 3, 4, 3 };
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            while (!st.isEmpty() && nums[st.peek() % n] < nums[i % n]) {
                ans[st.pop() % n] = nums[i % n];
            }
            if (i < n) {
                st.push(i);
            }
        }
        return ans;
    }
}
