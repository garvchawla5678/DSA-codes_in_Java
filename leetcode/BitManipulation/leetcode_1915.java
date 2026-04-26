package leetcode.BitManipulation;

public class leetcode_1915 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "abbccd";
		System.out.println(wonderfulSubstrings(word));
	}

	public static long wonderfulSubstrings(String word) {
		long[] cum_xor = new long[1024];
		int prefix_xor = 0;
		cum_xor[prefix_xor] = 1;
		long result = 0;

		for (char ch : word.toCharArray()) {
			int shift = (ch - 'a');

			prefix_xor ^= (1 << shift);

			result += cum_xor[prefix_xor];

			for (int i = 0; i <= 9; i++) {
				result += cum_xor[prefix_xor ^ (1 << i)];
			}

			cum_xor[prefix_xor]++;
		}

		return result;
	}
}
