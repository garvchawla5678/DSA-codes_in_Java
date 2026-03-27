package leetcode.HashMap;

public class leetocde_1347_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetcode";
		String t = "practice";
		System.out.println(minSteps(s, t));
	}

	public static int minSteps(String s, String t) {
		char[] ss = s.toCharArray();
		char[] tt = t.toCharArray();
		int[] freq = new int[27];
		for (char ch : ss)
			freq[ch - 'a']++;

		int steps = 0;
		for (char ch : tt)
			freq[ch - 'a']--;
		for (int x : freq) {
			steps += Math.abs(x);
		}

		return steps / 2;
	}
}
