package leetcode.SquareRootDecomposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class leetcode_3655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 3, 1, 5, 4 };
		int[][] queries = { { 1, 4, 2, 3 }, { 0, 2, 1, 2 } };
		System.out.println(xorAfterQueries(nums, queries));
	}

	public static int xorAfterQueries(int[] nums, int[][] queries) {
		int n = nums.length;
		HashMap<Integer, List<int[]>> map = new HashMap<>();
		int blockSize = (int) Math.ceil(Math.sqrt(n));
		int MOD = 1000000007;

		for (int[] quer : queries) {
			int k = quer[2];
			if (k >= blockSize) {
				int l = quer[0];
				int r = quer[1];
				int v = quer[3];
				for (int i = l; i <= r; i += k) { // this loop's complexity is O(square root of n)
					nums[i] = (int) (1L * nums[i] * v % MOD);
				}
			} else {
				if (!map.containsKey(k))
					map.put(k, new ArrayList<>());

				map.get(k).add(quer);
			}
		}

		for (int k : map.keySet()) {
			int[] diff = new int[n];
			Arrays.fill(diff, 1);

			for (int[] quer : map.get(k)) {
				int l = quer[0];
				int r = quer[1];
				int v = quer[3];

				diff[l] = (int) (1L * diff[l] * v % MOD);
				int steps = (r - l) / k;
				int next = l + (steps + 1) * k;
				if (next < n)
					diff[next] = (int) ((long) diff[next] * modPow1(v, MOD - 2, MOD) % MOD);
			}

			// cumulative product
			for (int i = 0; i < n; i++) {
				if (i - k >= 0)
					diff[i] = (int) (1L * diff[i] * diff[i - k] % MOD);
			}

			for (int i = 0; i < n; i++) {
				nums[i] = (int) (1L * nums[i] * diff[i] % MOD);
			}
		}

		int result = 0;
		for (int num : nums) {
			result ^= num;
		}

		return result;
	}

	public static long modPow(long base, long exp, int MOD) {
		long result = 1;
		base %= MOD;

		while (exp > 0) {
			if ((exp & 1) == 1)
				result = (result * base) % MOD;

			base = (base * base) % MOD;
			exp >>= 1;
		}

		return result;
	}

	public static long modPow1(long base, long exp, int MOD) {
		if (exp == 0)
			return 1;

		long half = modPow1(base, exp / 2, MOD);
		long result = (half * half) % MOD;
		if (exp % 2 == 1)
			result = (base * result) % MOD;

		return result;
	}
}
