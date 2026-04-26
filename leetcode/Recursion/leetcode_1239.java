package leetcode.Recursion;

import java.util.ArrayList;
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
		return solve(arr, 0, n, "");
	}

	private static int solve(List<String> arr, int idx, int n, String tmp) {
		if (idx == n)
			return tmp.length();

		int take = 0;
		int notTaken = 0;
		if (hasDuplicate(arr.get(idx), tmp)) {
			notTaken = solve(arr, idx + 1, n, tmp);
		} else {
			notTaken = solve(arr, idx + 1, n, tmp);

			take = solve(arr, idx + 1, n, tmp + arr.get(idx));
		}

		return Math.max(take, notTaken);
	}

	private static boolean hasDuplicate(String string, String tmp) {
		int[] freq = new int[26];
		for (char ch : string.toCharArray()) {
			if (freq[ch - 'a'] > 0)
				return true;
			freq[ch - 'a']++;
		}

		for (char ch : tmp.toCharArray()) {
			if (freq[ch - 'a'] > 0)
				return true;
		}

		return false;
	}
}
