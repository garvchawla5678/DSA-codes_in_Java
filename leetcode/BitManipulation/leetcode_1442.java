package leetcode.BitManipulation;

import java.util.HashMap;
import java.util.Map;

public class leetcode_1442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 3, 1, 6, 7 };
		System.out.println(countTriplets(arr));
	}

	public static int countTriplets(int[] arr) {
		// Time Complexity: O(n^2)

//		int triplets = 0;
//		int n = arr.length;
//
//		for (int i = 0; i < n; i++) {
//			int cum_xor = arr[i];
//			for (int k = i + 1; k < n; k++) {
//				cum_xor ^= arr[k];
//				if (cum_xor == 0) {
//					triplets += k - i;
//				}
//			}
//		}
//
//		return triplets;

		// Time Complexity: O(n)
		int triplets = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 0);
		int n = arr.length;
		int prefix_xor = 0;

		for (int i = 0; i < n; i++) {
			prefix_xor ^= arr[i];
			if (map.containsKey(prefix_xor)) {
				triplets += (i - map.get(prefix_xor));
			}
			map.put(prefix_xor, i + 1);
		}

		return triplets;
	}
}
