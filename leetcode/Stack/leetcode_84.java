package leetcode.Stack;

public class leetcode_84 {
    static void main() {
        int[] arr = {4,2,0,3,2,4,3,4};
        System.out.println(largestRectangleArea(arr));
    }
    public static int largestRectangleArea(int[] heights) {
        int ans = 0;
        int i = 0;
        int j = heights.length - 1;

        while (i <= j) {
            int minH = heights[i];
            for (int k = i; k <= j; k++) {
                minH = Math.min(minH, heights[k]);
            }
            ans = Math.max(ans, minH * (j - i + 1));

            if (heights[i] <= heights[j]) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
