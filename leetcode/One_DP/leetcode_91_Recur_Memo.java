package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_91_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "111111111111111111111111111111111111111111111";
		System.out.println(numDecodings(s));
	}

	public static int numDecodings(String s) {
		int[] memo = new int[s.length() + 1];
		Arrays.fill(memo, -1);

		return solve(s, 0, s.length(), memo);
	}

	private static int solve(String s, int idx, int n, int[] memo) {
		if (idx == n)
			return 1;
		if (memo[idx] != -1)
			return memo[idx];

		if (s.charAt(idx) == '0')
			return 0;

		int ways = solve(s, idx + 1, n, memo);

		if (idx + 1 < n) {
			if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6'))
				ways += solve(s, idx + 2, n, memo);
		}

		return memo[idx] = ways;
	}
}
