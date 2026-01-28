package leetcode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_2542 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = { 1, 3, 3, 2 };
		int[] nums2 = { 2, 1, 3, 4 };
		int k = 3;
		System.out.println(maxScore(nums1, nums2, k));
	}

	public static long maxScore(int[] nums1, int[] nums2, int k) {
		long score = 0;
		int n = nums1.length;
		int[][] pair = new int[n][2];

		for (int i = 0; i < n; i++) {
			pair[i][0] = nums1[i];
			pair[i][1] = nums2[i];
		}

		Arrays.sort(pair, (a, b) -> b[1] - a[1]);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int KSum = 0;
		for (int i = 0; i < k; i++) {
			KSum += pair[i][0];
			pq.add(pair[i][0]);
		}

		score = (long) KSum * pair[k - 1][1];

		for (int i = k; i < n; i++) {
			KSum += pair[i][0] - pq.poll();
			pq.add(pair[i][0]);
			score = Math.max(score, (long) KSum * pair[i][1]);
		}
		return score;
	}
}
