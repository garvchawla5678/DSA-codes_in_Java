package leetcode.BitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_1239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> arr = new ArrayList<>();
		arr.add("cha");
		arr.add("r");
		arr.add("act");
		arr.add("ers");
		System.out.println(maxLength(arr));
	}

	public static int maxLength(List<String> arr) {
		int n = arr.size();
		int[] mask = new int[n];
		Arrays.fill(mask, -1);

		for (int i = 0; i < n; i++) {
			int m = 0;
			for (char ch : arr.get(i).toCharArray()) {
				int bit = (1 << (ch - 'a'));
				if ((m & bit) != 0) {
					m = -1;
					break;
				}
				m = m | bit;
			}

			mask[i] = m;
		}

		return solve(mask, 0, n, 0);
	}

	private static int solve(int[] mask, int idx, int n, int tmp) {
		if (idx == n)
			return Integer.bitCount(tmp);

		int notTaken = solve(mask, idx + 1, n, tmp);
		int take = 0;

		if (mask[idx] != -1 && (tmp & mask[idx]) == 0) {
			take = solve(mask, idx + 1, n, tmp | mask[idx]);
		}

		return Math.max(take, notTaken);
	}
}
