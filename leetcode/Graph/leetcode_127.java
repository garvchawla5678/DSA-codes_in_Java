package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class leetcode_127 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new ArrayList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(ladderLength(beginWord, endWord, wordList));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>(wordList);
		if (!dict.contains(endWord))
			return 0;

		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		int level = 1;

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String word = q.poll();
				if (word.equals(endWord))
					return level;

				char[] arr = word.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					char old = arr[i];
					for (char c = 'a'; c <= 'z'; c++) {
						arr[i] = c;
						String next = new String(arr);
						if (dict.contains(next)) {
							q.add(next);
							dict.remove(next);
						}
					}
					arr[i] = old;
				}
			}
			level++;
		}
		return 0;
	}
}
