package leetcode.PrefixSum;

public class leetcode_3070 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 7, 6, 3 }, { 6, 6, 1 } };
		int k = 18;
		System.out.println(countSubmatrices(grid, k));
	}

	public static int countSubmatrices(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] help = new int[m][n];
		int count = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				help[i][j] = grid[i][j];

				if (i > 0)
					help[i][j] += help[i - 1][j];
				if (j > 0)
					help[i][j] += help[i][j - 1];
				if (i > 0 && j > 0)
					help[i][j] -= help[i - 1][j - 1];

				if (help[i][j] <= k)
					count++;
			}
		}

		return count;
	}

}
