package leetcode;

import java.util.Arrays;

public class leetcode_1914 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 1, 2, 3, 4 }, { 16, 1, 2, 5 }, { 15, 8, 3, 6 }, { 14, 7, 4, 7 }, { 13, 6, 5, 8 },
				{ 12, 11, 10, 9 } };
		int[][] ans = rotateGrid(grid, 1);
		for (int[] row : ans)
			System.out.println(Arrays.toString(row));
	}

	public static int[][] rotateGrid(int[][] grid, int k) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] ans = new int[m][n];

		int layers = Math.min(m / 2, n / 2);

		for (int layer = 0; layer < layers; layer++) {
			int top = layer;
			int bottom = m - layer - 1;
			int left = layer;
			int right = n - layer - 1;

			int no_of_elements = 2 * (bottom - top + 1) + 2 * (right - left + 1) - 4;
			int[] nums = new int[no_of_elements];
			int j = 0;

			// top layer of the layer
			for (int i = left; i <= right; i++) {
				nums[j++] = grid[top][i];
			}

			// right-most column of the layer
			for (int i = top + 1; i < bottom; i++) {
				nums[j++] = grid[i][right];
			}

			// bottom layer of the layer
			for (int i = right; i > left; i--) {
				nums[j++] = grid[bottom][i];
			}

			// left-most column of the layer
			for (int i = bottom; i > top; i--) {
				nums[j++] = grid[i][top];
			}

			// System.out.println(Arrays.toString(nums));

			// now reversing the nums array k times
			int temp_k = k;
			temp_k = k % no_of_elements;

			int[] temp = new int[no_of_elements];
			for (int i = 0; i < no_of_elements; i++) {
				if (i + temp_k >= no_of_elements) {
					temp[i] = nums[i + temp_k - no_of_elements];
				} else {
					temp[i] = nums[i + temp_k];
				}
			}

			// System.out.println(Arrays.toString(temp));

			j = 0;
			// top layer of the layer
			for (int i = left; i <= right; i++) {
				ans[top][i] = temp[j++];
			}

			// right-most column of the layer
			for (int i = top + 1; i < bottom; i++) {
				ans[i][right] = temp[j++];
			}

			// bottom layer of the layer
			for (int i = right; i > left; i--) {
				ans[bottom][i] = temp[j++];
			}

			// left-most column of the layer
			for (int i = bottom; i > top; i--) {
				ans[i][top] = temp[j++];
			}

		}

		return ans;
	}

}
