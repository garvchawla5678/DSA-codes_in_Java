package leetcode.Greedy;

import java.util.ArrayList;
import java.util.List;

public class leetcode_763 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcbacadefegdehijhklij";
		System.out.println(partitionLabels(s));
	}

	public static List<Integer> partitionLabels(String s) {
		int[] lastSeen = new int[26];
		char[] word = s.toCharArray();
		int n = word.length;

		for (int i = 0; i < n; i++) {
			lastSeen[word[i] - 'a'] = i;
		}

		int i = 0;
		List<Integer> ans = new ArrayList<>();

		while (i < n) {
			int end = lastSeen[word[i] - 'a'];
			int j = i;
			while (j <= end) {
				end = Math.max(end, lastSeen[word[j] - 'a']);
				j++;
			}

			ans.add(end - i + 1);
			i = j;
		}

		return ans;
	}
}
