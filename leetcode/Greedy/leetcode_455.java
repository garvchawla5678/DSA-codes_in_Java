package leetcode.Greedy;

import java.util.Arrays;

public class leetcode_455 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] g = { 5, 3, 1, 2 };
		int[] s = { 4, 1, 2, 3 };
		System.out.println(findContentChildren(g, s));
	}

	public static int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);
		int count = 0;
		int i = 0;
		int j = 0;
		while (i < g.length && j < s.length) {
			if (g[i] <= s[j]) {
				count++;
				i++;
				j++;
			} else {
				j++;
			}
		}

		return count;
	}
}
