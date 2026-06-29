package leetcode.Greedy;

public class leetcode_3633 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] landStartTime = { 2, 8 };
		int[] landDuration = { 4, 1 };
		int[] waterStartTime = { 6 };
		int[] waterDuration = { 3 };
		System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));
	}

	public static int earliestFinishTime(int[] startL, int[] durL, int[] startW, int[] durW) {
		int minL = 3000, minW = minL, res = minW;
		int n = startL.length;
		int m = startW.length;

		for (int i = 0; i < n; i++)
			minL = Math.min(minL, startL[i] + durL[i]);

		for (int i = 0; i < m; i++) {
			minW = Math.min(minW, startW[i] + durW[i]);
			res = Math.min(res, Math.max(minL, startW[i]) + durW[i]);
		}

		for (int i = 0; i < n; i++)
			res = Math.min(res, Math.max(minW, startL[i]) + durL[i]);

		return res;
	}
}
