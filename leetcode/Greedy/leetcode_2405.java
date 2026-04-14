package leetcode.Greedy;

public class leetcode_2405 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abacaba";
		System.out.println(partitionString(s));
	}

	public static int partitionString(String s) {
		char[] wrd = s.toCharArray();
		int[] freq = new int[26];

		int cuts = 0;
		for (char ch : wrd) {
			if (freq[ch - 'a'] > 0) {
				cuts++;
				freq = new int[26];
			}

			freq[ch - 'a']++;
		}

		return cuts + 1;
	}
}
