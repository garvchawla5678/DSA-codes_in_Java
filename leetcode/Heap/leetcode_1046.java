package leetcode.Heap;

import java.util.PriorityQueue;

public class leetcode_1046 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = { 2, 7, 4, 1, 8, 1 };
		System.out.println(lastStoneWeight(stones));
	}

	public static int lastStoneWeight(int[] stones) {
		PriorityQueue<Integer> qu = new PriorityQueue<>((a, b) -> b - a);
		for (int i : stones) {
			qu.add(i);
		}
		while (qu.size() > 1) {
			int a = qu.poll();
			int b = qu.poll();
			if (a == b)
				continue;
			qu.add(Math.abs(a - b));
		}
		int ans = qu.size() == 0 ? 0 : qu.poll();
		return ans;
	}
}
