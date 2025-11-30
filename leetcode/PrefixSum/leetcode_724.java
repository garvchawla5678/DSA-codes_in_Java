package leetcode.PrefixSum;

public class leetcode_724 {
    public static void main(String[] args) {
        int[] arr = { 1, 7, 3, 6, 5, 6 };
        System.out.println(pivotIndex(arr));
    }

    static int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        for (int i : nums) {
            totalSum += i;
        }
        int leftSum = 0;
        int rightSum;
        for (int i = 0; i < n; i++) {
            rightSum = totalSum - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
