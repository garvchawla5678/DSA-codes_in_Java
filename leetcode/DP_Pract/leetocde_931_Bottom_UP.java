package leetcode.DP_Pract;

public class leetocde_931_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		System.out.println(minFallingPathSum(matrix));
	}

	public static int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;

		if (n == 1)
			return matrix[0][0];

		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++)
			dp[n - 1][i] = matrix[n - 1][i];

		for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				int leftDiag = (j - 1 < 0) ? Integer.MAX_VALUE : dp[i + 1][j - 1];
				int rightDiag = (j + 1 >= n) ? Integer.MAX_VALUE : dp[i + 1][j + 1];
				int bottomDiag = dp[i + 1][j];

				dp[i][j] = matrix[i][j] + Math.min(rightDiag, Math.min(leftDiag, bottomDiag));
			}
		}

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			res = Math.min(res, dp[0][i]);
		}

		return res;
	}
}
