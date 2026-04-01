package leetcode.Stack;

import java.util.Stack;

public class leetcode_678 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
		System.out.println(checkValidString(s)); // 1 "(", 7 "*"
	}

	public static boolean checkValidString(String s) {
		char[] wrd = s.toCharArray();
		int n = wrd.length;

		Stack<Integer> star = new Stack<>();
		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (wrd[i] == '(')
				st.push(i);
			else if (wrd[i] == '*')
				star.push(i);
			else if (wrd[i] == ')') {
				if (!st.isEmpty())
					st.pop();
				else {
					if (star.isEmpty())
						return false;
					else if (star.peek() < i) {
						star.pop();
					} else
						return false;
				}
			}
		}

		while (!st.isEmpty()) {
			int idx = st.pop();
			if (star.isEmpty())
				return false;
			else if (star.peek() > idx) {
				star.pop();
			} else
				return false;
		}

		return true;
	}

}
