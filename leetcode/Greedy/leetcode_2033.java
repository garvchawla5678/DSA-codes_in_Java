package leetcode.Greedy;

public class leetcode_2033 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 2, 4 }, { 6, 8 } };
		int x = 2;
		System.out.println(minOperations(grid, x));
	}

	public static int minOperations(int[][] grid, int x) {
		int m = grid.length, n = grid[0].length;
		int[] freq = new int[100001];
		int min = grid[0][0], max = min;

		for (int[] row : grid) {
			for (int val : row) {
				if ((val - grid[0][0]) % x != 0) {
					return -1;
				}

				freq[val]++;
				min = Math.min(min, val);
				max = Math.max(max, val);
			}
		}

		int median = grid[0][0], acc = 0;
		int target = (m * n + 1) / 2;

		for (int i = min; i <= max; i += x) {
			acc += freq[i];
			if (acc >= target) {
				median = i;
				break;
			}
		}

		int res = 0;
		for (int i = min; i <= max; i += x) {
			int val = Math.abs(i - median);
			res += (val / x) * freq[i];
		}

		return res;
	}
}
