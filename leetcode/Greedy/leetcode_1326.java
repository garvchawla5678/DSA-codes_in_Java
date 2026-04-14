package leetcode.Greedy;

public class leetcode_1326 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] ranges = { 3, 4, 1, 0, 2, 3, 2, 1 };
		System.out.println(minTaps(n, ranges));
	}

	public static int minTaps(int n, int[] ranges) {
		int[] maxReach = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			if (ranges[i] == 0)
				continue;

			int left = Math.max(0, i - ranges[i]);
			maxReach[left] = Math.max(maxReach[left], Math.min(n, i + ranges[i]));
		}

		int taps = 0;
		int l = 0;
		int r = 0;
		int maxReachable = 0;

		while (r < n) {
			if (l > maxReachable)
				return -1;

			for (int k = l; k <= r; k++) {
				maxReachable = Math.max(maxReach[k], maxReachable);
			}

			l = r + 1;
			r = maxReachable;
			taps++;
		}

		return taps;
	}
}
