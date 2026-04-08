package leetcode.Greedy;

public class leetcode_135 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = { 9, 7, 7, 0, 2, 5, 1 };
		System.out.println(candy(ratings));
	}

	public static int candy(int[] ratings) {
		int n = ratings.length;
		int[] left = new int[n];

		left[0] = 1;
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				left[i] = 1 + left[i - 1];
			} else
				left[i] = 1;
		}

		int right = 1, curr = 1, sum = Math.max(left[n - 1], 1);
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				curr = 1 + right;
				right = curr;
			} else {
				curr = 1;
				right = curr;
			}

			sum += Math.max(left[i], curr);
		}

		return sum;
	}
}
