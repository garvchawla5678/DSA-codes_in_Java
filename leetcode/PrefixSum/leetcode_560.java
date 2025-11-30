package leetcode.PrefixSum;

import java.util.HashMap;

public class leetcode_560 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int k = 3;
        System.out.println(subArraySum(arr, k));
    }

    static int subArraySum(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
