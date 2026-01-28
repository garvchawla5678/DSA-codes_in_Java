package leetcode.Heap;

import java.util.PriorityQueue;

public class leetcode_1962 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = { 4, 3, 6, 7 };
		int k = 3;
		System.out.println(minStoneSum(piles, k));
	}

	public static int minStoneSum(int[] piles, int k) {
		int sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
		for (int i : piles) {
			pq.add(i);
			sum += i;
		}
		while (k-- > 0) {
			int temp = pq.poll();
			sum -= temp / 2;
			temp -= temp / 2;
			pq.add(temp);
		}

		return sum;
	}
}
