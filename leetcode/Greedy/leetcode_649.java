package leetcode.Greedy;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_649 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String senate = "DDRRRDR";
		System.out.println(predictPartyVictory(senate));
	}

	public static String predictPartyVictory(String senate) {
		// Time Complexity: O(n^2)

//		char[] arr = senate.toCharArray();
//		int countD = 0, countR = 0;
//		int n = arr.length;
//
//		for (char ch : arr) {
//			if (ch == 'R')
//				countR++;
//			else
//				countD++;
//		}
//
//		for (int i = 0; i < n; i++) {
//			if (arr[i] == '$')
//				continue;
//
//			if (arr[i] == 'D') {
//				int j = i + 1 % n;
//				while (arr[j % n] == 'D' || arr[j % n] != '$') {
//					j++;
//					if (j % n == i + 1 % n)
//						return "Dire";
//				}
//
//				arr[j % n] = '$';
//				countR--;
//			} else {
//				int j = i + 1 % n;
//				while (arr[j % n] == 'R' || arr[j % n] != '$') {
//					j++;
//					if (j % n == (i + 1) % n)
//						return "Radiant";
//				}
//
//				arr[j % n] = '$';
//				countD--;
//			}
//
//			if (countR == 0 || countD == 0) {
//				return (countR == 0) ? "Dire" : "Radiant";
//			}
//
//		}
//
//		return "";

		// Time Complexity: O(n)
		char[] arr = senate.toCharArray();
		Queue<Integer> d = new LinkedList<>();
		Queue<Integer> r = new LinkedList<>();
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			if (arr[i] == 'D')
				d.add(i);
			else
				r.add(i);
		}

		while (!d.isEmpty() && !r.isEmpty()) {
			int d1 = d.poll();
			int r1 = r.poll();

			if (d1 < r1) {
				d.add(d1 + n);
			} else {
				r.add(r1 + n);
			}
		}

		return r.isEmpty() ? "Dire" : "Radiant";
	}
}
