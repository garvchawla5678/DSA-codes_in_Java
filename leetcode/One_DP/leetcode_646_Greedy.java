package leetcode.One_DP;

import java.util.Arrays;

public class leetcode_646_Greedy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] pairs = { { 1, 2 }, { 7, 8 }, { 3, 4 } };
		System.out.println(findLongestChain(pairs));
	}

	public static int findLongestChain(int[][] pairs) {
		int n = pairs.length;

		Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));
		int count = 1;
		int prevEnd = pairs[0][1];

		for (int i = 1; i < n; i++) {
			if (pairs[i][0] > prevEnd) {
				count++;
				prevEnd = pairs[i][1];
			}
		}

		return count;
	}
}
