package leetcode.PrefixSum;

public class Count_Subarrays_With_Majority_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 1, 2, 2, 3 };
		int target = 2;
		System.out.println(countMajoritySubarrays(nums, target));
	}

	public static int countMajoritySubarrays(int[] nums, int target) {
		int n = nums.length;

		int[] prefix = new int[n + 1];

		for (int i = 0; i < n; i++)
			prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);

		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (prefix[j + 1] - prefix[i] > 0)
					ans++;
			}
		}

		return ans;
	}
}
