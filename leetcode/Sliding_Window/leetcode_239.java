package leetcode.Sliding_Window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class leetcode_239 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		int[] ans = maxSlidingWindow(nums, k);
		System.out.println(Arrays.toString(ans));
	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> deq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			while (!deq.isEmpty() && deq.peekFirst() <= i - k) {
				deq.pollFirst();
			}

			while (!deq.isEmpty() && nums[i] > nums[deq.peekLast()]) {
				deq.pollLast();
			}

			deq.offerLast(i);

			if (i >= k - 1) {
				result[i - k + 1] = nums[deq.peekFirst()];
			}
		}

		return result;
	}
}
