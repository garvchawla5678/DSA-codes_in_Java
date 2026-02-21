package leetcode.One_DP;

import java.util.ArrayList;
import java.util.List;

public class leetcode_131 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "nitin";
		System.out.println(partition(s));
	}

	public static List<List<String>> partition(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		boolean[][] dp = new boolean[n + 1][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				int j = i + len - 1;

				if (i == j)
					dp[i][j] = true;
				else if (i + 1 == j)
					dp[i][j] = (arr[i] == arr[j]);
				else {
					if (arr[i] == arr[j] && dp[i + 1][j - 1])
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
			}
		}

		List<List<String>> res = new ArrayList<>();
		solve(s, 0, new ArrayList<>(), res, arr.length, dp);

		return res;
	}

	private static void solve(String s, int idx, List<String> curr, List<List<String>> res, int n, boolean[][] dp) {
		if (idx == n) {
			res.add(new ArrayList<>(curr));
			return;
		}

		for (int i = idx; i < n; i++) {
			if (dp[idx][i]) {
				curr.add(s.substring(idx, i + 1));
				solve(s, i + 1, curr, res, n, dp);
				curr.removeLast();
			}
		}

	}
}
