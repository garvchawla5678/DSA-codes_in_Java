package leetcode.Heap;

public class leetcode_1962_opti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = { 4, 3, 6, 9 };
		int k = 3;
		System.out.println(minStoneSum(piles, k));
	}

	public static int minStoneSum(int[] piles, int k) {
		int[] frq = new int[100001];
		for (int i : piles) {
			frq[i]++;
		}
		int i = frq.length - 1;
		while (k > 0) {
			while (i > 0 && frq[i] == 0)
				i--;
			int count = Math.min(frq[i], k);
			k -= count;
			frq[i] -= count;
			frq[(i + 1) / 2] += count;
		}
		int sum = 0;
		for (int j = 0; j < frq.length; j++) {
			if (frq[j] != 0) {
				sum += frq[j] * j;
			}
		}
		return sum;
	}
}
