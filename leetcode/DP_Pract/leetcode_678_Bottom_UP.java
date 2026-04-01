package leetcode.DP_Pract;

public class leetcode_678_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
		System.out.println(checkValidString(s)); // 1 "(", 7 "*"
	}

	public static boolean checkValidString(String s) {
		char[] wrd = s.toCharArray();
		int n = wrd.length;
		boolean[][] dp = new boolean[n + 1][n + 1];

		dp[n][0] = true;
		for (int i = n - 1; i >= 0; i--) {
			for (int open = 0; open <= i + 1; open++) {
				boolean isValid = false;

				if (wrd[i] == '(') {
					isValid = dp[i + 1][open + 1];
				} else if (wrd[i] == '*') {
					isValid = isValid || dp[i + 1][open + 1]; // treating star as openBracket
					isValid = isValid || dp[i + 1][open]; // treating star as empty string
					if (open > 0) {
						isValid = isValid || dp[i + 1][open - 1]; // treating star as closeBracket
					}
				} else if (open > 0) {
					isValid = isValid || dp[i + 1][open - 1];
				}

				dp[i][open] = isValid;
			}
		}

		return dp[0][0];
	}
}
