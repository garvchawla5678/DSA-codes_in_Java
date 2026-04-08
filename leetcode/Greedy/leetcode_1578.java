package leetcode.Greedy;

public class leetcode_1578 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String colors = "abaaaac";
		int[] neededTime = { 1, 2, 3, 1, 4, 2, 5 };
		System.out.println(minCost(colors, neededTime));
	}

	public static int minCost(String colors, int[] neededTime) {
		char[] arr = colors.toCharArray();
		int n = arr.length;
		int time = 0;
		int i = 0;
		while (i < n - 1) {
			if (arr[i] == arr[i + 1]) {
				int left = i;
				int right = i + 1;
				while (right < n && arr[left] == arr[right]) {
					if (neededTime[left] < neededTime[right]) {
						time += neededTime[left];
						left = right;
					} else {
						time += neededTime[right];
					}
					right++;
				}
				i = right;
				continue;
			}
			i++;
		}

		return time;
	}
}
