package leetcode.Greedy;

public class leetcode_3474 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "TFTF";
		String str2 = "ab";
		System.out.println(generateString(str1, str2));
	}

	public static String generateString(String str1, String str2) {
		int n = str1.length();
		int m = str2.length();
		char[] ans = new char[n + m - 1];
		boolean[] canChange = new boolean[n + m - 1];

		for (int i = 0; i < n; i++) {
			if (str1.charAt(i) == 'T') {
				int k = i;
				for (int j = 0; j < m; j++) {
					if (ans[k] != 0 && ans[k] != str2.charAt(j)) {
						return "";
					}
					ans[k++] = str2.charAt(j);
				}
			}
		}

		for (int i = 0; i < n + m - 1; i++) {
			if (ans[i] == 0) {
				ans[i] = 'a';
				canChange[i] = true;
			}
		}

		for (int i = 0; i < n; i++) {
			if (str1.charAt(i) == 'F') {
				boolean isSame = true;
				int k = 0;
				for (int j = i; j <= i + m - 1; j++) {
					if (ans[j] != str2.charAt(k++)) {
						isSame = false;
						break;
					}
				}

				if (isSame) {
					boolean changed = false;
					for (int j = i + m - 1; j >= i; j--) {
						if (canChange[j]) {
							ans[j] = 'b';
							changed = true;
							break;
						}
					}

					if (!changed)
						return "";
				}
			}
		}

		return new String(ans);
	}
}
