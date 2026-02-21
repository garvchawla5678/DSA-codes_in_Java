package leetcode.One_DP;

public class leetcode_647_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc";
		System.out.println(countSubstrings(s));
	}

	public static int countSubstrings(String s) {
		int count = 0;
		int n = s.length();
		boolean[][] dp = new boolean[n + 1][n + 1];

		for (int len = 1; len <= n; len++) {
			for (int i = 0; i + len - 1 < n; i++) {
				int j = i + len - 1;
				if (i == j)
					dp[i][j] = true;
				else if (i + 1 == j)
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				else {
					if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1])
						dp[i][j] = true;
					else
						dp[i][j] = false;
				}
				if (dp[i][j])
					count++;
			}
		}

		return count;
	}
}
