package leetcode.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class leetcode_973 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 1, 3 }, { 2, -2 }, { -2, 2 } };
		int k = 2;
		int[][] ans = kClosest(points, k);
		for (int[] arr : ans) {
			System.out.println(Arrays.toString(arr));
		}
	}

	public static int[][] kClosest(int[][] points, int k) {
		int p = k;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> distance(b) - distance(a));
		for (int[] point : points) {
			if (k-- > 0)
				pq.add(point);
			else if (distance(pq.peek()) > distance(point)) {
				pq.poll();
				pq.add(point);
			}
		}
		int[][] ans = new int[p][2];
		int i = 0;
		for (int[] point : pq) {
			ans[i++] = point;
		}
		return ans;
	}

	public static int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}
}
