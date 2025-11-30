package leetcode.Stack;

import java.util.Stack;

public class leetcode_84_stack {
    static void main() {
        int[] arr = { 4, 2, 0, 3, 2, 4, 3, 4 };
        System.out.println(largestRectangleArea(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int area = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while ((!st.isEmpty()) && heights[i] < heights[st.peek()]) {
                int height = heights[st.pop()];
                if (st.isEmpty()) {
                    area = Math.max(area, height * i);
                } else {
                    area = Math.max(area, height * (i - st.peek() - 1));
                }
            }
            st.push(i);
        }
        while (!st.isEmpty()) {
            int height = heights[st.pop()];
            if (st.isEmpty()) {
                area = Math.max(area, height * n);
            } else {
                area = Math.max(area, height * (n - st.peek() - 1));
            }
        }
        return area;
    }
}
