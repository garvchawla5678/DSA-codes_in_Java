package leetcode.BitManipulation;

public class leetcode_1404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "1101";
		System.out.println(numSteps(s));
	}

	public static int numSteps(String s) {
		int operations = 0, carry = 0;
		char[] arr = s.toCharArray();
		int n = arr.length;

		for (int i = n - 1; i > 0; i--) {
			if (((arr[i] - '0') + carry) % 2 == 1) {
				operations += 2;
				carry = 1;
			} else {
				operations++;
			}
		}

		return operations + carry;
	}

}
