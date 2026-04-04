package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_3661 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] robots = { 10, 2 };
		int[] distance = { 5, 1 };
		int[] walls = { 5, 2, 7 };
		leetcode_3661 cl = new leetcode_3661();
		System.out.println(cl.maxWalls(robots, distance, walls));
	}

	public int maxWalls(int[] robots, int[] distance, int[] walls) {
		int m = robots.length;
		Arrays.sort(walls);

		int[][] pr = new int[m][2];
		for (int i = 0; i < m; i++) {
			pr[i][0] = robots[i];
			pr[i][1] = distance[i];
		}

		Arrays.sort(pr, (a, b) -> a[0] - b[0]);
		int[][] range = new int[m][2]; // leftrange and rightrange

		for (int i = 0; i < m; i++) {
			range[i][0] = Math.max((i - 1 >= 0 ? pr[i - 1][0] + 1 : 0), pr[i][0] - pr[i][1]);
			range[i][1] = Math.min((i + 1 < m ? pr[i + 1][0] - 1 : Integer.MAX_VALUE), pr[i][0] + pr[i][1]);
		}

		// 0 -> leftShoot, 1 -> rightShoot
		int[][] memo = new int[m + 1][2];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(pr, range, walls, 0, 0, m, memo);
	}

	private int solve(int[][] pr, int[][] range, int[] walls, int i, int direc, int m, int[][] memo) {
		if (i >= m)
			return 0;
		if (memo[i][direc] != -1)
			return memo[i][direc];

		int leftShoot = range[i][0];
		if (direc == 1) {
			leftShoot = Math.max(range[i - 1][1] + 1, leftShoot);
		}

		int countWallsLeft = count(walls, leftShoot, pr[i][0]) + solve(pr, range, walls, i + 1, 0, m, memo);

		int rightShoot = range[i][1];
		int countWallsRight = count(walls, pr[i][0], rightShoot) + solve(pr, range, walls, i + 1, 1, m, memo);

		return memo[i][direc] = Math.max(countWallsLeft, countWallsRight);
	}

	private int count(int[] walls, int l, int r) {
		int n = walls.length;
		int i = 0;
		int j = n - 1;
		int leftIdx = -1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (walls[mid] < l) {
				i = mid + 1;
			} else {
				leftIdx = mid;
				j = mid - 1;
			}
		}

		int rightIdx = -1;
		i = 0;
		j = n - 1;
		while (i <= j) {
			int mid = i + (j - i) / 2;
			if (walls[mid] <= r) {
				rightIdx = mid;
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}

		if (leftIdx == -1 || rightIdx == -1 || leftIdx > rightIdx)
			return 0;

		return rightIdx - leftIdx + 1;
	}
}
