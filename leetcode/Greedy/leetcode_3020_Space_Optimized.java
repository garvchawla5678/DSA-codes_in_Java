package leetcode.Greedy;

public class leetcode_3020_Space_Optimized {

	static final int MAX = 31623;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 5, 4, 1, 2, 2 };
		System.out.println(maximumLength(nums));
	}

	public static int maximumLength(int[] nums) {
		int freq[] = new int[MAX];
		boolean[] hasSquare = new boolean[MAX];

		for (int num : nums) {
			if (num < MAX)
				freq[num]++;

			int sq = (int) Math.sqrt(num);
			if (sq * sq == num)
				hasSquare[sq] = true;
		}

		int len = Math.max(1, (freq[1] % 2 == 1) ? freq[1] : freq[1] - 1);

		for (int i = 2; i < MAX; i++) {
			if (len >= 9)
				break;

			if (freq[i] < 2)
				continue;

			int currentBase = i;
			int tempLen = 0;
			while (currentBase < MAX && freq[currentBase] >= 2 && hasSquare[currentBase]) {
				tempLen += 2;
				currentBase = currentBase * currentBase;
			}

			len = Math.max(len, tempLen + 1);
		}

		return len;
	}
}
