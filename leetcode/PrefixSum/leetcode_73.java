package leetcode.PrefixSum;

import java.util.Arrays;

public class leetcode_73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);
		for (int[] row : matrix)
			System.out.println(Arrays.toString(row));
	}

	public static void setZeroes(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

//		boolean[] row = new boolean[m];
//		boolean[] col = new boolean[n];
//
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (matrix[i][j] == 0) {
//					row[i] = true;
//					col[j] = true;
//				}
//			}
//		}
//
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (row[i] || col[j])
//					matrix[i][j] = 0;
//			}
//		}

		// Space optimized soln:

		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;

		// checking for first row
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				firstRowHasZero = true;
				break;
			}
		}

		// checking for first col
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				firstColHasZero = true;
				break;
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[0][j] = 0;
					matrix[i][0] = 0;
				}
			}
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[0][j] == 0 || matrix[i][0] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (firstRowHasZero) {
			for (int i = 0; i < n; i++)
				matrix[0][i] = 0;
		}

		if (firstColHasZero) {
			for (int i = 0; i < m; i++)
				matrix[i][0] = 0;
		}
	}
}
