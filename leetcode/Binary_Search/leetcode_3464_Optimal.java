package leetcode.Binary_Search;

import java.util.Arrays;

public class leetcode_3464_Optimal {
	static long perimeter;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int side = 2;
		int[][] points = { { 0, 0 }, { 1, 2 }, { 2, 0 }, { 2, 2 }, { 2, 1 } };
		int k = 4;
		System.out.println(maxDistance(side, points, k));
	}

	public static int maxDistance(int side, int[][] points, int k) {
		int n = points.length;
		long[] positions = new long[n];
		int j = 0;
		long sidel = (long) side;
		perimeter = 4 * sidel;

		for (int[] row : points) {
			if (row[1] == 0) {
				positions[j++] = row[0];
			} else if (row[0] == sidel) {
				positions[j++] = sidel + row[1];
			} else if (row[1] == sidel) {
				positions[j++] = 3 * sidel - row[0];
			} else {
				positions[j++] = 4 * sidel - row[1];
			}
		}

		Arrays.sort(positions);
		long[] doubled = new long[2 * n];
		for (int i = 0; i < n; i++) {
			doubled[i] = positions[i];
			doubled[i + n] = positions[i] + perimeter;
		}

		int l = 0;
		int r = 2 * side;
		int ans = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;

			if (check(doubled, k, mid, n)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ans;
	}

	private static boolean check(long[] doubled, int k, int mid, int n) {

		for (int i = 0; i < n; i++) {
			int count = 1;
			int idx = i;
			long lastPos = doubled[idx];

			for (int j = 2; j <= k; j++) {
				long target = lastPos + mid;
				int trgt_idx = Arrays.binarySearch(doubled, idx + 1, i + n, target);

				if (trgt_idx < 0)
					trgt_idx = -trgt_idx - 1;

				if (trgt_idx >= i + n)
					break;

				idx = trgt_idx;
				lastPos = doubled[idx];
				count++;
			}

			if (count == k && ((doubled[i] + perimeter - lastPos) >= mid))
				return true;
		}

		return false;
	}
}
