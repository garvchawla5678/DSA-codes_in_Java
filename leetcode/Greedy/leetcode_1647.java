package leetcode.Greedy;

import java.util.Arrays;

public class leetcode_1647 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "accdcdadddbaadbc";
		System.out.println(minDeletions(s));
	}

	public static int minDeletions(String s) {
		int[] arr = new int[26];
		for (char ch : s.toCharArray()) {
			arr[ch - 'a']++;
		}

		Arrays.sort(arr);

		int deletions = 0;

		for (int i = 24; i >= 0; i--) {
			if (arr[i] == 0)
				break;

			if (arr[i] >= arr[i + 1]) {
				int prev = arr[i];
				arr[i] = arr[i + 1] - 1;
				deletions += (prev - arr[i]);
			}
		}

		return deletions;
	}
}
