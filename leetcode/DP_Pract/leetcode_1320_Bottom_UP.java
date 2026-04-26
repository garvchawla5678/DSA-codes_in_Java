package leetcode.DP_Pract;

public class leetcode_1320_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "MASHA";
		System.out.println(minimumDistance(word));
	}

	public static int minimumDistance(String word) {
		char[] wrd = word.toCharArray();
		int n = wrd.length;
		int[][][] dp = new int[n + 1][27][27];

		for (int i = n - 1; i >= 0; i--) {
			int curr = wrd[i] - 'A';

			for (int fing1 = 0; fing1 < 27; fing1++) {
				for (int fing2 = 0; fing2 < 27; fing2++) {
					if (fing1 == 26 && fing2 == 26) {
						dp[i][fing1][fing2] = dp[i + 1][curr][fing2];
						continue;
					}

					if (fing2 == 26) {
						int moveF2 = dp[i + 1][fing1][curr];

						int moveF1 = dist(curr, fing1) + dp[i + 1][curr][fing2];

						dp[i][fing1][fing2] = Math.min(moveF2, moveF1);
						continue;
					}

					int moveF2 = dist(curr, fing2) + dp[i + 1][fing1][curr];

					int moveF1 = dist(curr, fing1) + dp[i + 1][curr][fing2];

					dp[i][fing1][fing2] = Math.min(moveF2, moveF1);
				}
			}
		}

		return dp[0][26][26];
	}

	private static int dist(int wrd, int fing) {
		int r1 = wrd / 6, c1 = wrd % 6;
		int r2 = fing / 6, c2 = fing % 6;

		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
