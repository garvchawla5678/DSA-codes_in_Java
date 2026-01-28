package leetcode.Heap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class leetcode_621 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int k = 2;
		System.out.println(leastInterval(arr, k));
	}

	// Using PriorityQueue
	public static int leastInterval(char[] tasks, int n) {
		int[] arr = new int[27];
		for (char ch : tasks) {
			arr[ch - 'A']++;
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < 27; i++) {
			if (arr[i] != 0)
				pq.add(arr[i]);
		}
		int time = 0;

		while (!pq.isEmpty()) {
			ArrayList<Integer> ff = new ArrayList<>();

			for (int i = 1; i <= n + 1; i++) {
				if (!pq.isEmpty()) {
					int freq = pq.poll();
					freq--;
					ff.add(freq);
				}
			}

			for (int i : ff) {
				if (i != 0)
					pq.add(i);
			}
			if (pq.isEmpty())
				time += ff.size();
			else
				time += n + 1;
		}
		return time;
	}
}
