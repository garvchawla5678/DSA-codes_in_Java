package leetcode.Heap;

import java.util.Arrays;
import java.util.Random;

public class leetcode_973_opti {

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
		int start = 0;
		int end = points.length - 1;
		Random rn = new Random();
		while (true) {
			int pivot_index = start + rn.nextInt(end - start + 1);
			pivot_index = partition(points, start, end, pivot_index);
			if (pivot_index == k - 1) {
				return Arrays.copyOfRange(points, 0, k);
			} else if (pivot_index > k - 1) {
				end = pivot_index - 1;
			} else {
				start = pivot_index + 1;
			}
		}
	}

	public static int distance(int[] point) {
		return point[0] * point[0] + point[1] * point[1];
	}

	public static int partition(int[][] points, int start, int end, int pivot) {
		swap(points, start, pivot);
		int i = start + 1;
		int j = end;
		while (i <= j) {
			if (distance(points[i]) > distance(points[start]) && distance(points[j]) < distance(points[start])) {
				swap(points, i, j);
				i++;
				j--;
			}
			if (distance(points[i]) <= distance(points[start]))
				i++;
			if (distance(points[j]) >= distance(points[start]))
				j--;
		}
		swap(points, j, start);
		return j;
	}

	public static void swap(int[][] points, int i, int j) {
		int[] temp = points[i];
		points[i] = points[j];
		points[j] = temp;
	}
}
