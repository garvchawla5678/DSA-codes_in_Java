package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String txt = "abbccdeabbc";
		String pat = "abbc";
		System.out.println(matching(txt, pat));
	}

	public static List<Integer> matching(String txt, String pat) {
		int m = pat.length();
		int n = txt.length();
		char[] text = txt.toCharArray();
		char[] pattern = pat.toCharArray();

		int[] lps = new int[m];
		computeLPS(pattern, lps, m);
		System.out.println(Arrays.toString(lps));

		int i = 0;
		int j = 0;
		List<Integer> res = new ArrayList<>();

		while (i < n) {
			if (j < m && text[i] == pattern[j]) {
				i++;
				j++;
			}

			if (j == m) {
				res.add(i - j);
				j = lps[j - 1];
			} else if (text[i] != pattern[j]) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}

		return res;
	}

	private static void computeLPS(char[] pattern, int[] lps, int m) {
		int i = 1;
		int len = 0;

		while (i < m) {
			if (pattern[i] == pattern[len]) {
				lps[i] = ++len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}
}
