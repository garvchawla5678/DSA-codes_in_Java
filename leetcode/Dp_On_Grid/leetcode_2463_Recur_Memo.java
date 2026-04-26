package leetcode.Dp_On_Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_2463_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> robot = new ArrayList<>();
		robot.add(0);
		robot.add(4);
		robot.add(6);
		int[][] factory = { { 2, 2 }, { 6, 2 } };
		System.out.println(minimumTotalDistance(robot, factory));
	}

	public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
		Collections.sort(robot);
		Arrays.sort(factory, (a, b) -> a[0] - b[0]);
		int n = robot.size();
		int m = factory.length;

		long[][] dp = new long[n][m];
		for (long[] row : dp)
			Arrays.fill(row, -1);

		return solve(robot, factory, 0, 0, n, m, dp);
	}

	private static long solve(List<Integer> robot, int[][] factory, int idx, int fac, int n, int m, long[][] dp) {
		if (idx == n)
			return 0;

		if (fac == m)
			return (long) 1e15;

		if (dp[idx][fac] != -1)
			return dp[idx][fac];

		long res = solve(robot, factory, idx, fac + 1, n, m, dp);

		long cost = 0;
		int pos = factory[fac][0];
		int limit = factory[fac][1];

		for (int k = 0; k < limit && idx + k < n; k++) {
			cost += Math.abs(robot.get(idx + k) - pos);
			res = Math.min(res, cost + solve(robot, factory, idx + k + 1, fac + 1, n, m, dp));
		}

		return dp[idx][fac] = res;
	}
}
