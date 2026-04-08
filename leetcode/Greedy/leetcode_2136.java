package leetcode.Greedy;

import java.util.Arrays;

public class leetcode_2136 {
	class Pair {
		int plantTime;
		int growTime;

		Pair(int t, int v) {
			plantTime = t;
			growTime = v;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] plantTime = { 1, 2, 3, 2 };
		int[] growTime = { 2, 1, 2, 1 };
		leetcode_2136 cl = new leetcode_2136();
		System.out.println(cl.earliestFullBloom(plantTime, growTime));
	}

	public int earliestFullBloom(int[] plantTime, int[] growTime) {
		int n = plantTime.length;
		Pair[] prr = new Pair[n];

		for (int i = 0; i < n; i++) {
			prr[i] = new Pair(plantTime[i], growTime[i]);
		}

		Arrays.sort(prr, (a, b) -> b.growTime - a.growTime);
		int maxBloomDays = 0;
		int prevPlantDays = 0;

		for (int i = 0; i < n; i++) {
			int currPlantTime = prr[i].plantTime;
			int currGrowTime = prr[i].growTime;

			prevPlantDays += currPlantTime;

			int bloomTime = prevPlantDays + currGrowTime;
			maxBloomDays = Math.max(maxBloomDays, bloomTime);
		}

		return maxBloomDays;
	}
}
