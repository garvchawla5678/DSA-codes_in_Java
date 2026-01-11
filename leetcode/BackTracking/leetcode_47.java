package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class leetcode_47 {
    static void main() {
        int[] nums = { 1, 1, 2 };
        System.out.println(permuteUnique(nums));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ch : nums) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        solve(nums, ans, map, new ArrayList<>());
        return ans;
    }
    static void solve(int[] nums, List<List<Integer>> ans, HashMap<Integer,Integer> map, List<Integer> ans1) {
        if(ans1.size() == nums.length) {
            ans.add(new ArrayList<>(ans1));
            return;
        }
        for (int num : map.keySet()) {
            if (map.get(num) > 0) {
                map.put(num, map.get(num) - 1);
                ans1.add(num);
                solve(nums, ans, map, ans1);
                ans1.removeLast();
                map.put(num, map.get(num) + 1);
            }
        }
    }
}
