package leetcode.BitManipulation;

public class leetcode_2939 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = 12;
		long b = 5;
		int n = 4;
		System.out.println(maximumXorProduct(a, b, n));
	}

	public static int maximumXorProduct(long a, long b, int n) {
		long aXorX = 0;
		long bXorX = 0;

		// 49th bit to n, copy a or b to their xor products value
		for (long i = 49; i >= n; i--) {
			boolean a_ith_bit = ((a >> i) & 1) > 0; // ith bit -> 1 if true
			boolean b_ith_bit = ((b >> i) & 1) > 0;

			if (a_ith_bit) {
				aXorX = (aXorX ^ (1L << i));
			}

			if (b_ith_bit) {
				bXorX = (bXorX ^ (1L << i));
			}
		}

		for (long i = n - 1; i >= 0; i--) {
			boolean a_ith_bit = ((a >> i) & 1) > 0; // ith bit -> 1 if true
			boolean b_ith_bit = ((b >> i) & 1) > 0;

			if (a_ith_bit == b_ith_bit) {
				aXorX = (aXorX ^ (1L << i));
				bXorX = (bXorX ^ (1L << i));
			} else {
				if (aXorX > bXorX) {
					bXorX = (bXorX ^ (1L << i));
				} else {
					aXorX = (aXorX ^ (1L << i));
				}
			}
		}

		aXorX = aXorX % 1_000_000_007;
		bXorX = bXorX % 1_000_000_007;

		return (int) (aXorX * bXorX % 1_000_000_007);
	}
}
