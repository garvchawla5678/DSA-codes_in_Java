package leetcode.PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode_2615 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 3, 1, 1, 2 };
		System.out.println(Arrays.toString(distance(nums)));
	}

	public static long[] distance(int[] nums) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
		}

		long[] res = new long[n];
		for (List<Integer> list : map.values()) {
			int size = list.size();
			if (size <= 1) {
				continue;
			}

			long[] prefixSum = new long[size];
			prefixSum[0] = list.getFirst();
			for (int i = 1; i < size; i++) {
				prefixSum[i] = prefixSum[i - 1] + list.get(i);
			}

			for (int i = 0; i < size; i++) {
				long leftSum = (i == 0) ? 0 : prefixSum[i - 1];
				int noOfLeftElements = i;
				long rightSum = (i == size - 1) ? 0 : prefixSum[size - 1] - prefixSum[i];
				int noOfRightElements = size - noOfLeftElements - 1;

				res[list.get(i)] = (((long) list.get(i) * noOfLeftElements) - leftSum)
						+ (rightSum - ((long) list.get(i) * noOfRightElements));
			}
		}

		return res;
	}
}
