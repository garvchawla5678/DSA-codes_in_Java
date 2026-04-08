package leetcode.Greedy;

public class leetcode_134 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		System.out.println(canCompleteCircuit(gas, cost));
	}

	public static int canCompleteCircuit(int[] gas, int[] cost) {
		// Brute force approach
//		int m = gas.length;
//
//		for (int idx = 0; idx < m; idx++) {
//			int j = idx;
//			int reserve = 0;
//
//			while (j < m + idx) {
//				reserve += gas[j % m];
//				if (cost[j % m] > reserve) {
//					break;
//				} else {
//					reserve -= cost[j % m];
//					j++;
//				}
//
//				if (idx == j % m)
//					return idx;
//			}
//		}
//
//		return -1;

		int m = gas.length;

		int totalGas = 0;
		int totalCost = 0;
		for (int i = 0; i < gas.length; i++) {
			totalGas += gas[i];
			totalCost += cost[i];
		}
		if (totalCost > totalGas) {
			return -1;
		}

		int total = 0;
		int result = 0;

		for (int i = 0; i < m; i++) {
			total += gas[i] - cost[i];

			if (total < 0) {
				total = 0;
				result = i + 1;
			}
		}

		return result;
	}
}
