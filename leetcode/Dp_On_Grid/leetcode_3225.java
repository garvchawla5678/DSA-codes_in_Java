package leetcode.Dp_On_Grid;

public class leetcode_3225 {

	int n;
	long[][][] memo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0, 0, 0 }, { 0, 0, 3, 0, 0 }, { 0, 1, 0, 0, 0 }, { 5, 0, 0, 3, 0 },
				{ 0, 0, 0, 0, 2 } };
		leetcode_3225 cl = new leetcode_3225();
		System.out.println(cl.maximumScore(grid));
	}

	public long maximumScore(int[][] grid) {
		n = grid.length;
		long[][] prefixSum = new long[n + 1][n + 1];

		memo = new long[2][101][101];
		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 101; j++)
				java.util.Arrays.fill(memo[i][j], -1);

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				prefixSum[i][j] = prefixSum[i - 1][j] + grid[i - 1][j - 1];
			}
		}

		return solve(false, 0, 0, prefixSum);
	}

	private long solve(boolean prevTaken, int col, int prevHeight, long[][] prefixSum) {
		if (col == n) {
			return 0;
		}

		if (memo[prevTaken ? 1 : 0][prevHeight][col] != -1)
			return memo[prevTaken ? 1 : 0][prevHeight][col];

		long result = 0;

		for (int height = 0; height <= n; height++) {
			long prevColScore = 0;
			long curColScore = 0;

			if (!prevTaken && height > prevHeight) {
				prevColScore += prefixSum[height][col] - prefixSum[prevHeight][col];
			}

			if (prevHeight > height) {
				curColScore += prefixSum[prevHeight][col + 1] - prefixSum[height][col + 1];
			}

			long takeCurrent = curColScore + prevColScore + solve(true, col + 1, height, prefixSum);

			long skipCurrent = prevColScore + solve(false, col + 1, height, prefixSum);

			result = Math.max(result, Math.max(takeCurrent, skipCurrent));
		}

		return memo[prevTaken ? 1 : 0][prevHeight][col] = result;
	}
}
