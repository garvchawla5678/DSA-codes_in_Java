package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_90 {
    static void main() {
        int[] nums = {1, 2, 2};
        List<List<Integer>> ans = subsets(nums);
        System.out.println(ans);
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, 0, new ArrayList<>());
        return ans;
    }
    static void solve(int[] nums, List<List<Integer>> ans, int idx, List<Integer> ans1) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(ans1));
            return;
        }

        ans1.add(nums[idx]);
        solve(nums , ans, idx + 1, ans1);
        ans1.removeLast();

        while(idx + 1 < nums.length && nums[idx] == nums[idx + 1]) idx++;
        solve(nums, ans, idx + 1, ans1);
    }
}
