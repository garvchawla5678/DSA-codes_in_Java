package leetcode.Greedy;

public class leetcode_1846 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 2, 1, 2, 1 };
		System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
	}

	// can also do this question by just sorting and then looping
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		int[] freq = new int[100001];
		int n = arr.length;

		for (int num : arr) {
			freq[Math.min(num, n)]++;
		}

		int acc = 0;
		for (int i = 1; i <= n; i++) {
			acc += freq[i];
			freq[i] = 0;

			if (acc > i)
				acc = i;
		}

		return acc;
	}

}
