package leetcode.Greedy;

public class leetcode_135_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = { 9, 7, 7, 0, 2, 5, 1 };
		System.out.println(candy(ratings));
	}

	public static int candy(int[] ratings) {
		int n = ratings.length;
		int sum = 1;
		int i = 1;

		while (i < n) {
			if (ratings[i] == ratings[i - 1]) {
				i++;
				sum++;
				continue;
			}

			int peak = 1;
			while (i < n && ratings[i] > ratings[i - 1]) {
				peak++;
				sum += peak;
				i++;
			}

			int down = 1;
			while (i < n && ratings[i] < ratings[i - 1]) {
				sum += down;
				down++;
				i++;
			}

			if (down > peak) {
				sum += (down - peak);
			}
		}

		return sum;
	}
}
