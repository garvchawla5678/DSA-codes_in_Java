package leetcode.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_1665 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] tasks = { { 1, 7 }, { 2, 8 }, { 3, 9 }, { 4, 10 }, { 5, 11 }, { 6, 12 } };
		System.out.println(minimumEffort(tasks));
	}

	public static int minimumEffort(int[][] tasks) {
		int n = tasks.length;
		Arrays.sort(tasks, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				int diff1 = a[1] - a[0];
				int diff2 = b[1] - b[0];

				return diff2 - diff1;
			}
		});
		for (int[] row : tasks) {
			System.out.print(Arrays.toString(row) + " ");
		}
		System.out.println();

		int effort = 0;

		for (int i = n - 1; i >= 0; i--) {
			effort = Math.max(tasks[i][1], effort + tasks[i][0]);
		}

		return effort;
	}
}
