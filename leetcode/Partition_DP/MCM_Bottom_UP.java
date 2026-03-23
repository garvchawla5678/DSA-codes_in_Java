package leetcode.Partition_DP;

public class MCM_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 1, 3, 4 };
		System.out.println(matrixMultiplication(arr));
	}

	public static int matrixMultiplication(int[] arr) {
		int n = arr.length;
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= j)
					dp[i][j] = 0;
				else
					dp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = n - 1; i >= 1; i--) {
			for (int j = i + 1; j < n; j++) {
				for (int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (arr[i - 1] * arr[k] * arr[j]));
				}
			}
		}

		return dp[1][n - 1];
	}
}
