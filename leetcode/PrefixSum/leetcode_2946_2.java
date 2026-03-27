package leetcode.PrefixSum;

public class leetcode_2946_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 3;
		System.out.println(areSimilar(grid, k));
	}

	public static boolean areSimilar(int[][] mat, int k) {
		int n = mat.length;
		int m = mat[0].length;
		k = k % m;
		if (k == 0)
			return true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (i % 2 == 0) {
					if (mat[i][j] != mat[i][(j + k) % m])
						return false;
				} else {
					if (mat[i][j] != mat[i][(j - k + m) % m])
						return false;
				}
			}
		}

		return true;
	}
}
