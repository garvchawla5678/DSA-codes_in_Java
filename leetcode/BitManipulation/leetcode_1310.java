package leetcode.BitManipulation;

import java.util.Arrays;

public class leetcode_1310 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 4, 8 };
		int[][] queries = { { 0, 1 }, { 1, 2 }, { 0, 3 }, { 3, 3 } };
		System.out.println(Arrays.toString(xorQueries(nums, queries)));
	}

	public static int[] xorQueries(int[] arr, int[][] queries) {
		int n = arr.length;
		int[] prefixXor = new int[n];
		prefixXor[0] = arr[0];

		for (int i = 1; i < n; i++) {
			prefixXor[i] = prefixXor[i - 1] ^ arr[i];
		}

		int m = queries.length;
		int[] ans = new int[m];
		int i = 0;
		for (int[] quer : queries) {
			int left = quer[0];
			int right = quer[1];
			ans[i++] = prefixXor[right] ^ ((left == 0) ? 0 : prefixXor[left - 1]);
		}

		return ans;
	}
}
