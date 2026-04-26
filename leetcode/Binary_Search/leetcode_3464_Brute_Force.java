package leetcode.Binary_Search;

import java.util.ArrayList;
import java.util.List;

public class leetcode_3464_Brute_Force {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int side = 2;
		int[][] points = { { 0, 0 }, { 1, 2 }, { 2, 0 }, { 2, 2 }, { 2, 1 } };
		int k = 4;
		System.out.println(maxDistance(side, points, k));
	}

	public static int maxDistance(int side, int[][] points, int k) {
		int l = 0;
		int r = 2 * side;
		int ans = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			List<Integer> vector = new ArrayList<>();

			if (check(points, k, mid, vector, 0)) {
				ans = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		return ans;
	}

	private static boolean check(int[][] points, int k, int mid, List<Integer> vector, int i) {
		if (vector.size() == k)
			return true;

		for (int idx = i; idx < points.length; idx++) {
			boolean valid = true;

			for (int ii : vector) {
				if (manhattanDist(points[ii], points[idx]) < mid) {
					valid = false;
					break;
				}
			}

			if (!valid)
				continue;

			vector.add(idx);
			if (check(points, k, mid, vector, idx + 1)) {
				return true;
			}

			vector.removeLast();
		}

		return false;
	}

	private static int manhattanDist(int[] p1, int[] p2) {
		return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
	}
}
