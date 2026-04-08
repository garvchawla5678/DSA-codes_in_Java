package leetcode.Greedy;

public class leetcode_991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int startValue = 5;
		int target = 8;
		System.out.println(brokenCalc(startValue, target));
	}

	public static int brokenCalc(int startValue, int target) {
		if (startValue >= target)
			return startValue - target;

		if (target % 2 == 0) {
			return 1 + brokenCalc(startValue, target / 2);
		} else {
			return 1 + brokenCalc(startValue, target + 1);
		}
	}
}
