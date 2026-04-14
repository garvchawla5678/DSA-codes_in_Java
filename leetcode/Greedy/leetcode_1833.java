package leetcode.Greedy;

public class leetcode_1833 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] costs = { 1, 3, 2, 4, 1 };
		int coins = 7;
		System.out.println(maxIceCream(costs, coins));
	}

	public static int maxIceCream(int[] costs, int coins) {
		int max = -1;
		for (int x : costs) {
			max = Math.max(max, x);
		}

		int[] freq = new int[max + 1];
		for (int num : costs) {
			freq[num]++;
		}

		int count = 0;
		for (int i = 1; i < max + 1; i++) {
			if (freq[i] == 0)
				continue;

			if (coins <= 0)
				break;

			if (freq[i] * i <= coins) {
				count += freq[i];
				coins -= freq[i] * i;
			} else {
				count += (coins / i);
				coins -= (coins / i) * i;
			}
		}

		return count;
	}
}
