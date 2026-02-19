package leetcode.One_DP;

public class leetcode_70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 44;
		leetcode_70 cl = new leetcode_70();
		System.out.println(cl.climbStairs(n));
	}

	public int climbStairs(int n) {
		if (n == 1 || n == 2)
			return n;

		int[] ansBuilding = new int[n + 1];
		solve(n, ansBuilding);
		return ansBuilding[n];
	}

	int solve(int n, int[] ansBuilding) {
		if (n == 1 || n == 2)
			return n;
		if (ansBuilding[n] != 0)
			return ansBuilding[n];

		int one_step = 0;
		int two_step = 0;
		if (n - 1 >= 0)
			one_step = solve(n - 1, ansBuilding);
		if (n - 2 >= 0)
			two_step = solve(n - 2, ansBuilding);

		ansBuilding[n] = one_step + two_step;
		return ansBuilding[n];
	}
}
