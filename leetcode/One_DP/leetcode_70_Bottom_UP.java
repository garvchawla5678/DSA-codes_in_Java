package leetcode.One_DP;

public class leetcode_70_Bottom_UP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 44;
		System.out.println(climbStairs(n));
	}

	public static int climbStairs(int n) {
		if (n <= 2)
			return n;

		int[] arr = new int[n + 1]; // here i represents the no. of ways to climb i no. of stairs
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i <= n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[n];
	}
}
