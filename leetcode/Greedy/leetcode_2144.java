package leetcode.Greedy;

public class leetcode_2144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] cost = { 75, 48, 82, 89, 60, 78, 49, 94, 61, 33, 76, 30, 3, 89, 29, 25, 44, 31, 90, 28, 29, 28, 86, 28,
				15, 13, 29, 12, 83, 57, 24, 56, 51, 2, 81, 18, 21, 21, 6, 80, 18, 28, 90, 37, 45, 74, 6 };
		System.out.println(minimumCost(cost));
	}

	public static int minimumCost(int[] cost) {
		int[] freq = new int[101];
		int max = -1;
		int n = cost.length;
		if (n <= 2) {
			return (n == 1) ? cost[0] : cost[0] + cost[1];
		}

		for (int num : cost) {
			freq[num]++;
			max = Math.max(num, max);
		}

		int ans = 0;

		for (int i = max; i >= 0; i--) {
			while (freq[i] > 0) {
				freq[i]--;

				int j = i;
				while (j >= 0 && freq[j] == 0)
					j--;

				if (j < 0)
					return ans + i;

				freq[j]--;
				ans += i + j;

				while (j >= 0 && freq[j] == 0)
					j--;

				if (j >= 0)
					freq[j]--;
			}
		}

		return ans;
	}
}
