package leetcode.Simple_but_can_learn_new_things;

import java.util.Arrays;

public class leetcode_48 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };

		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}

		System.out.println();
		rotate(matrix);

		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static void rotate(int[][] matrix) {
		int n = matrix.length;

		// Approach - 1
//		for (int i = 0; i < m; i++) {
//			for (int j = i + 1; j < n; j++) {
//				int temp = matrix[i][j];
//				matrix[i][j] = matrix[j][i];
//				matrix[j][i] = temp;
//			}
//		}
//
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n / 2; j++) {
//				int temp = matrix[i][j];
//				matrix[i][j] = matrix[i][n - 1 - j];
//				matrix[i][n - 1 - j] = temp;
//			}
//		}

		// Approach - 2 (in one iteration)
		// (i, j) -> maps to (j, n - 1 - i)
		// for how it is derived or verified you can look at this leetcoder's solution:
		// https://leetcode.com/problems/rotate-image/solutions/8134784/direct-rotation-1-pass-by-la_castille-u6bl/
		// cyclic changes

		for (int i = 0; i < n >> 1; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int t = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = t;
			}
		}
	}
}
