package leetcode.BitManipulation;

public class leetcode_3007_brute_force {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 9;
		int x = 1;
		System.out.println(findMaximumNumber(k, x));
	}

	public static long findMaximumNumber(long k, int x) {
		int num = 1;
		int sum = 0;

		while (true) {
			int price = getPrice(num, x);

			if (sum + price > k)
				break;
			else {
				sum += price;
			}

			num++;
		}

		return num - 1;
	}

	private static int getPrice(int num, int x) {
		int price = 0;

		while (num != 0) {
			boolean tt = ((1 << (x - 1)) & num) > 0;
			if (tt)
				price++;

			num = num >> x;
		}

		return price;
	}
}
