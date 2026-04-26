package leetcode.Dp_On_Grid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class leetcode_2463_Bottom_UP {

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

		long[][] dp = new long[n + 1][m + 1];
		for (long[] row : dp)
			Arrays.fill(row, (long) 1e15);

		for (int i = 0; i < m; i++)
			dp[0][i] = 0;

		for (int f = 1; f <= m; f++) {
			int limit = factory[f - 1][1];
			int pos = factory[f - 1][0];

			for (int r = 0; r <= n; r++) {
				dp[r][f] = dp[r][f - 1];

				long cost = 0;
				for (int k = 1; k <= limit && r - k >= 0; k++) {
					cost += Math.abs(robot.get(r - k) - pos);
					dp[r][f] = Math.min(dp[r][f], cost + dp[r - k][f - 1]);
				}
			}
		}

		return dp[n][m];
	}

}
