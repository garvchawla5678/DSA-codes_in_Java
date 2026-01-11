package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_46_1 {
    static void main() {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, 0);
        return ans;
    }
    static void solve(int[] nums, List<List<Integer>> ans, int idx) {
        if(idx == nums.length) {
            List<Integer> ans1 = new ArrayList<>();
            for(int num : nums) {
                ans1.add(num);
            }
            ans.add(ans1);
            return;
        }
        for(int i = idx; i < nums.length; i++) {
            swap(nums, idx, i);
            solve(nums, ans, idx + 1);
            swap(nums, idx, i);
        }
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
