package leetcode.HashMap;

public class leetcode_242 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "anagram";
		String t = "naagrma";
		System.out.println(isAnagram(s, t));
	}

	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] chr = new int[26];
		for (char ch : s.toCharArray()) {
			chr[ch - 'a']++;
		}

		for (char ch : t.toCharArray()) {
			if (chr[ch - 'a'] <= 0)
				return false;
			chr[ch - 'a']--;
		}
		return true;
	}
}
