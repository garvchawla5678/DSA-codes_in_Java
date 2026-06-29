package leetcode.PrefixSum;

public class Count_Subarrays_With_Majority_Elements_Optimizerd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2, 3 };
		int target = 2;
		System.out.println(countMajoritySubarrays(nums, target));
	}

	public static int countMajoritySubarrays(int[] nums, int target) {
		int n = nums.length;

		int[] freq = new int[2 * n + 1];
		int cumSum = 0;
		freq[cumSum + n] = 1;

		int ans = 0;
		int validLeftPoints = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] == target) {
				validLeftPoints += freq[cumSum + n];
				cumSum += 1;

				ans += validLeftPoints;
				freq[cumSum + n] += 1;
			} else {
				cumSum -= 1;
				validLeftPoints -= freq[cumSum + n];

				ans += validLeftPoints;
				freq[cumSum + n] += 1;
			}
		}

		return ans;
	}
}
