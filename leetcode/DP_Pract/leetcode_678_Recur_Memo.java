package leetcode.DP_Pract;

import java.util.Arrays;

public class leetcode_678_Recur_Memo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
		System.out.println(checkValidString(s)); // 1 "(", 7 "*"
	}

	public static boolean checkValidString(String s) {
		char[] wrd = s.toCharArray();
		int n = wrd.length;
		int[][] memo = new int[n + 1][n + 1];
		for (int[] row : memo)
			Arrays.fill(row, -1);

		return solve(wrd, 0, 0, n, memo);
	}

	private static boolean solve(char[] wrd, int i, int openCount, int n, int[][] memo) {
		if (i == n) {
			return openCount == 0;
		}

		if (memo[i][openCount] != -1)
			return memo[i][openCount] == 1 ? true : false;

		boolean isValid = false;
		if (wrd[i] == '(') {
			isValid = solve(wrd, i + 1, openCount + 1, n, memo);
		} else if (wrd[i] == '*') {
			isValid = isValid || solve(wrd, i + 1, openCount + 1, n, memo); // treating star as openBracket
			isValid = isValid || solve(wrd, i + 1, openCount, n, memo); // treating star as empty string
			if (openCount > 0) {
				isValid = isValid || solve(wrd, i + 1, openCount - 1, n, memo); // treating star as closeBracket
			}
		} else if (openCount > 0) {
			isValid = isValid || solve(wrd, i + 1, openCount - 1, n, memo);
		}

		memo[i][openCount] = (isValid == true) ? 1 : 0;
		return isValid;
	}
}
