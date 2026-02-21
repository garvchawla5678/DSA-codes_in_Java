package leetcode.One_DP;

public class leetcode_5_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "babad";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();
		boolean[][] dp = new boolean[n + 1][n + 1];

		int start = 0;
		int end = 0;
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

				if (dp[i][j] && (end - start + 1) < len) {
					start = i;
					end = j;
				}
			}
		}

		return s.substring(start, end + 1);
	}
}
