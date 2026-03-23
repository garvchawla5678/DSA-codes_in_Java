package leetcode.Partition_DP;

public class Boolean_Parenthesis_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "T|T&F^T";
		System.out.println(countWays(s));
	}

	public static int countWays(String s) {
		char[] wrd = s.toCharArray();
		int n = wrd.length;
		int[][][] dp = new int[n + 1][n + 1][2];

		for (int i = 0; i < n; i += 2) {
			dp[i][i][1] = (wrd[i] == 'T' ? 1 : 0);
			dp[i][i][0] = (wrd[i] == 'F' ? 1 : 0);
		}

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i + 2; j < n; j += 2) {
				int waysT = 0;
				int waysF = 0;
				for (int idx = i + 1; idx <= j - 1; idx += 2) {
					int leftTrueWays = dp[i][idx - 1][1];
					int leftFalseWays = dp[i][idx - 1][0];
					int rightTrueWays = dp[idx + 1][j][1];
					int rightFalseWays = dp[idx + 1][j][0];

					if (wrd[idx] == '&') {
						waysT += leftTrueWays * rightTrueWays;
						waysF += (leftFalseWays * rightFalseWays) + (leftFalseWays * rightTrueWays)
								+ (leftTrueWays * rightFalseWays);

					} else if (wrd[idx] == '|') {
						waysT += (leftTrueWays * rightTrueWays) + (leftTrueWays * rightFalseWays)
								+ (leftFalseWays * rightTrueWays);
						waysF += leftFalseWays * rightFalseWays;

					} else {
						waysT += (leftFalseWays * rightTrueWays) + (leftTrueWays * rightFalseWays);
						waysF += (leftFalseWays * rightFalseWays) + (leftTrueWays * rightTrueWays);

					}
					dp[i][j][1] = waysT;
					dp[i][j][0] = waysF;
				}
			}
		}

		return dp[0][n - 1][1];
	}
}
