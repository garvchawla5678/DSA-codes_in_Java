package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class leetcode_47_1 {
    static void main() {
        int[] nums = { 1, 1, 2 };
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
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
        HashSet<Integer> set = new HashSet<>();
        for(int i = idx; i < nums.length; i++) {
            if(!set.contains(nums[i])) {
                set.add(nums[i]);
                swap(nums, i, idx);
                solve(nums, ans, idx + 1);
                swap(nums, i, idx);
            }
        }
    }
    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
