package leetcode.BitManipulation;

public class leetcode_3007_Optimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 9;
		int x = 1;
		System.out.println(findMaximumNumber(k, x));
	}

	public static long findMaximumNumber(long k, int x) {
		long left = 0;
		long right = (long) 1e15;
		long result = 0;
		// long[] bitCount = new long[65];

		while (left <= right) {
			long mid = left + (right - left) / 2;
			// Arrays.fill(bitCount, 0);

			// getBitsCount(mid, bitCount);
			long totalPrice = getPrice(mid, x);
//			int bitLength = (int) (Math.log(mid) / Math.log(2)) + 1;
//
//			for (int i = 0; i < bitLength; i++) {
//				if ((i + 1) % x == 0)
//					totalPrice += bitCount[i];
//			}

			if (totalPrice <= k) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return result;
	}

	private static void getBitsCount(long mid, long[] bitCount) {
		if (mid == 0)
			return;

		if (mid == 1) {
			bitCount[0] += 1;
			return;
		}

		if (mid == 2) {
			bitCount[0] += 1;
			bitCount[1] += 1;
			return;
		}

		int bitLength = (int) (Math.log(mid) / Math.log(2)) + 1;

		long nearestPower2 = (1L << (bitLength - 1));
		bitCount[bitLength - 1] += mid - nearestPower2 + 1;

		for (int i = 0; i < bitLength - 1; i++) {
			bitCount[i] += nearestPower2 / 2;
		}

		mid = mid - nearestPower2;
		getBitsCount(mid, bitCount);
	}

	private static long getPrice(long num, int x) {
		int bitLength = (int) (Math.log(num) / Math.log(2)) + 1;
		// increment num to account 0th row in the count of groups
		num++;

		long price = 0;
		while (bitLength > 0) {
			if (bitLength % x == 0) {
				price += (num / (1L << bitLength)) * (1L << (bitLength - 1))
						+ Math.max(0, num % (1L << bitLength) - (1L << (bitLength - 1)));
			}

			bitLength--;
		}

		return price;
	}
}
