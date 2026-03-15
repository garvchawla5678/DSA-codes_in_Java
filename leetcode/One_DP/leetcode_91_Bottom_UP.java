package leetcode.One_DP;

public class leetcode_91_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "111111111111111111111111111111111111111111111";
		System.out.println(numDecodings(s));
	}

	public static int numDecodings(String s) {
		int n = s.length();
		int[] dp = new int[n + 1];
		char[] arr = s.toCharArray();

		dp[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] == '0')
				dp[i] = 0;
			else {
				dp[i] = dp[i + 1];
				if (i + 1 < n)
					if (arr[i] == '1' || (arr[i] == '2' && arr[i + 1] <= '6'))
						dp[i] += dp[i + 2];
			}
		}

		return dp[0];
	}
}
