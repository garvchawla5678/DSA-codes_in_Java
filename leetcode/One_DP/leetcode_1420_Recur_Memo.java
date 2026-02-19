package leetcode.One_DP;

public class leetcode_1420_Recur_Memo {

	static int N;
	static int M;
	static int K;
	static final int mod = 1000000007;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int m = 3;
		int k = 1;
		System.out.println(numOfArrays(n, m, k));
	}

	public static int numOfArrays(int n, int m, int k) {
		N = n;
		M = m;
		K = k;
		int[][][] memo = new int[51][51][101];

		return solve(0, 0, -1, memo);
	}

	private static int solve(int idx, int cost, int maxSoFar, int[][][] memo) {
		if (idx == N) {
			if (cost == K)
				return 1;
			return 0;
		}

		if (memo[idx][cost][maxSoFar + 1] != 0)
			return memo[idx][cost][maxSoFar + 1];

		int result = 0;
		for (int i = 1; i <= M; i++) {
			if (maxSoFar < i) {
				result += solve(idx + 1, cost + 1, i, memo);
			} else {
				result += solve(idx + 1, cost, maxSoFar, memo);
			}
		}

		return memo[idx][cost][maxSoFar + 1] = result % mod;
	}
}
