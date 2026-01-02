package leetcode.Binary_Search;

public class leetcode_410 {
    static void main() {
        int[] arr = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(arr, k));
    }

    public static int splitArray(int[] nums, int k) {
        int ans = -1;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int start = 0;
        int end = sum;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isItPossible(nums, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    static boolean isItPossible(int[] nums, int k, int max) {
        int count = 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                count++;
                sum = 0;
                i--;
            }
            if (count > k) {
                return false;
            }
        }
        return true;
    }
}
