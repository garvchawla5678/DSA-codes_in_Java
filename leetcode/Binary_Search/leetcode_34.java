package leetcode.Binary_Search;

import java.util.Arrays;

public class leetcode_34 {
    static void main() {
        int[] nums = { 2, 3, 5, 7, 7, 7, 7, 8, 9, 10 };
        int target = 7;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = { -1, -1 };
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                ans[0] = mid;
                end = mid - 1;
            }
        }
        start = 0;
        end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                ans[1] = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
