package leetcode.Binary_Search;

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

				return diff1 - diff2;
			}
		});
		for (int[] row : tasks) {
			System.out.print(Arrays.toString(row) + " ");
		}
		System.out.println();

		int l = 0;
		int r = 1_000_000_000;
		int effort = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (check(tasks, mid, n)) {
				effort = mid;
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}

		return effort;
	}

	private static boolean check(int[][] tasks, int mid, int n) {
		int initailEffort = mid;

		for (int i = n - 1; i >= 0; i--) {
			if (tasks[i][1] > initailEffort)
				return false;
			else {
				initailEffort -= tasks[i][0];
			}
		}

		return true;
	}
}
