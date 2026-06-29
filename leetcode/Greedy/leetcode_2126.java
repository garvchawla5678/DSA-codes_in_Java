package leetcode.Greedy;

public class leetcode_2126 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mass = 10;
		int[] asteroids = { 3, 9, 19, 5, 21 };
		System.out.println(asteroidsDestroyed(mass, asteroids));
	}

	public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
		// Arrays.sort(asteroids);

		// long currMass = mass;
		// for (int num : asteroids) {
		// if (num > currMass)
		// return false;

		// currMass += num;
		// }

		// return true;

		int[] freq = new int[100001];
		int startIdx = 1_000_000_007;
		int endIdx = -1_000_000_007;

		for (int num : asteroids) {
			freq[num]++;
			startIdx = Math.min(startIdx, num);
			endIdx = Math.max(endIdx, num);
		}

		long currMass = mass;
		for (int i = startIdx; i <= endIdx; i++) {
			if (freq[i] != 0) {
				if (i > currMass)
					return false;

				if (currMass >= 100000)
					return true;

				currMass += (long) i * freq[i];
			}
		}

		return true;
	}
}
