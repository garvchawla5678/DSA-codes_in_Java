package leetcode.Greedy;

import java.util.Arrays;

public class leetcode_948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tokens = { 100, 200, 300, 400 };
		int power = 200;
		System.out.println(bagOfTokensScore(tokens, power));
	}

	public static int bagOfTokensScore(int[] tokens, int power) {
		int n = tokens.length;
		if (n == 0)
			return 0;

		Arrays.sort(tokens);

		if (tokens[0] > power)
			return 0;

		int score = 0;
		int currScore = 0;

		int i = 0;
		int j = n - 1;
		while (i <= j) {
			if (power >= tokens[i]) {
				power -= tokens[i];
				currScore += 1;
				score = Math.max(currScore, score);
				i++;
			} else if (score > 0) {
				power += tokens[j];
				currScore--;
				j--;
			} else {
				return score;
			}
		}

		return score;
	}
}
