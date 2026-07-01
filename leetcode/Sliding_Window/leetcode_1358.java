package leetcode.Sliding_Window;

public class leetcode_1358 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaabc";
		System.out.println(numberOfSubstrings(s));
	}

	public static int numberOfSubstrings(String s) {
		int[] freq = new int[3];
		char[] wrd = s.toCharArray();
		int i = 0, j = 0;
		int n = wrd.length;
		int res = 0;

		while (j < n) {
			freq[wrd[j] - 'a']++;
			while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
				res += n - j;
				freq[wrd[i] - 'a']--;
				i++;
			}
			j++;
		}

		return res;
	}
}
