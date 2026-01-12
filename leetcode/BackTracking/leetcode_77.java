package leetcode.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class leetcode_77 {
    static void main() {
        int n = 5;
        int k = 3;
        System.out.println(combine(n,k));
    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }
    static void solve(int n, int k, List<List<Integer>> ans, List<Integer> cur, int idx) {
        if(k == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = idx; i <= n; i++){
            cur.add(i);
            solve(n, k - 1, ans, cur, i + 1);
            cur.removeLast();
        }
    }
}
