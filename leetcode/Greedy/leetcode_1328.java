package leetcode.Greedy;

public class leetcode_1328 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String palindrome = "abccba";
		System.out.println(breakPalindrome(palindrome));
	}

	public static String breakPalindrome(String palindrome) {
		char[] wrd = palindrome.toCharArray();
		int n = wrd.length;

		if (n == 1)
			return "";

		for (int i = 0; i < n / 2; i++) {
			if (wrd[i] != 'a') {
				wrd[i] = 'a';
				return new String(wrd);
			}
		}

		wrd[n - 1] = 'b';
		return new String(wrd);
	}
}
