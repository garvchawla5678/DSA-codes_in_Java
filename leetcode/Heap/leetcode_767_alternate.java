package leetcode.Heap;

public class leetcode_767_alternate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "vvvlo";
		System.out.println(reorganizeString(s));
	}

	public static String reorganizeString(String s) {
		int n = s.length();

		int maxFreq = 0;
		int maxChar = 0;
		int[] frq = new int[26];

		for (char ch : s.toCharArray()) {
			frq[ch - 'a']++;

			if (frq[ch - 'a'] > maxFreq) {
				maxFreq = frq[ch - 'a'];
				maxChar = ch - 'a';
			}
			if (frq[ch - 'a'] > (n + 1) / 2)
				return "";
		}

		char[] ans = s.toCharArray();
		int i = 0;

		// alternatively fill maxfrequent character
		while (frq[maxChar] > 0) {
			ans[i] = (char) (maxChar + 'a');
			i += 2;
			frq[maxChar]--;
		}

		// now fill remaining characters in the empty slot(kind of empty) because our
		// main concern(the most freq element is already filled)
		for (char ch = 'a'; ch <= 'z'; ch++) {
			while (frq[ch - 'a'] > 0) {
				if (i >= n)
					i = 1;
				ans[i] = ch;
				frq[ch - 'a']--;
				i += 2;
			}
		}

		return new String(ans);
	}
}
