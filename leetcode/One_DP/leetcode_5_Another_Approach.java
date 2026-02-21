package leetcode.One_DP;

public class leetcode_5_Another_Approach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cbbd";
		System.out.println(longestPalindrome(s));
	}

	public static String longestPalindrome(String s) {
		int n = s.length();
		char[] arr = s.toCharArray();

		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			int odd = expand(arr, i, i, n);
			int even = expand(arr, i, i + 1, n);

			int maxLen = Math.max(odd, even);
			if (maxLen > (end - start + 1)) {
				start = i - (maxLen - 1) / 2;
				end = i + (maxLen / 2);
			}
		}

		return s.substring(start, end + 1);
	}

	private static int expand(char[] arr, int i, int j, int n) {

		while (i >= 0 && j < n && arr[i] == arr[j]) {
			i--;
			j++;
		}

		return j - i - 1;
	}
}
