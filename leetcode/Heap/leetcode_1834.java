package leetcode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_1834 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] task = { { 7, 10 }, { 7, 12 }, { 7, 5 }, { 7, 4 }, { 7, 2 } };
		System.out.println(Arrays.toString(getOrder(task)));
	}

	public static int[] getOrder(int[][] tasks) {
		int n = tasks.length;
		int[][] arr = new int[n][3];
		int k = 0;
		for (int[] num : tasks) {
			arr[k] = new int[] { num[0], num[1], k };
			k++;
		}
		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
		PriorityQueue<int[]> qu = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
		long current_time = 0;
		int idx = 0;
		int i = 0;
		int[] ans = new int[n];
		while (idx < n || !qu.isEmpty()) {
			if (qu.isEmpty() && current_time < arr[idx][0])
				current_time = arr[idx][0];
			while (idx < n && arr[idx][0] <= current_time) {
				qu.add(arr[idx]);
				idx++;
			}
			int[] temp = qu.poll();
			ans[i++] = temp[2];
			current_time += temp[1];
		}
		return ans;
	}
}
