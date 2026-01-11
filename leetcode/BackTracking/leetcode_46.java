package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode_46 {
    static void main() {
        int[] nums = { 1, 2, 3 };
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, ans, new HashSet<>(), new ArrayList<>());
        return ans;
    }
    static void solve(int[] nums, List<List<Integer>> ans, Set<Integer> temp, List<Integer> ans1) {
        if(temp.size() == nums.length) {
            ans.add(new ArrayList<>(ans1));
            return;
        }
        for (int ch : nums) {
            if (!temp.contains(ch)) {
                ans1.add(ch);
                temp.add(ch);
                solve(nums, ans, temp, ans1);
                ans1.removeLast();
                temp.remove(ch);
            }
        }
    }
}
