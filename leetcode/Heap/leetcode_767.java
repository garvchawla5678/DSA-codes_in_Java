package leetcode.Heap;

import java.util.PriorityQueue;

public class leetcode_767 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "vvvlo";
		System.out.println(reorganizeString(s));
	}

	public static String reorganizeString(String s) {
		StringBuilder ans = new StringBuilder();
		int n = s.length();
		int[][] frq = new int[27][2];
		for (char ch : s.toCharArray()) {
			frq[ch - 'a'][0] = ch - 'a';
			frq[ch - 'a'][1]++;
			if (frq[ch - 'a'][1] > (n + 1) / 2)
				return "";
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		for (int[] arr : frq)
			if (arr[1] != 0)
				pq.add(arr);

		while (!pq.isEmpty()) {
			if (pq.size() >= 2) {
				int[] first = pq.poll();
				int[] second = pq.poll();
				ans.append((char) (first[0] + 'a'));
				ans.append((char) (second[0] + 'a'));
				first[1]--;
				second[1]--;
				if (first[1] != 0)
					pq.add(first);
				if (second[1] != 0)
					pq.add(second);
			}
			if (pq.size() == 1) {
				int[] temp = pq.poll();
				if (temp[1] > 1)
					return "";
				else
					ans.append((char) (temp[0] + 'a'));
			}
		}
		return ans.toString();
	}
}
