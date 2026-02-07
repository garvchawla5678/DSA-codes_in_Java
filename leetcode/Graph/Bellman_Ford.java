package leetcode.Graph;

import java.util.Arrays;

public class Bellman_Ford {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 5;
		int[][] edges = { { 1, 3, 2 }, { 4, 3, -1 }, { 2, 4, 1 }, { 1, 2, 1 }, { 0, 1, 5 } };
		int src = 0;
		System.out.println(Arrays.toString(bellmanFord(V, edges, src)));
	}

	public static int[] bellmanFord(int V, int[][] edges, int src) {
		// code here
		int[] result = new int[V];
		Arrays.fill(result, (int) Math.pow(10, 8));
		result[src] = 0;

		for (int i = 1; i <= V - 1; i++) {
			for (int[] arr : edges) {
				int u = arr[0];
				int v = arr[1];
				int w = arr[2];

				if (result[u] != (int) Math.pow(10, 8) && w + result[u] < result[v]) {
					result[v] = w + result[u];
				}
			}
		}

		for (int[] arr : edges) {
			int u = arr[0];
			int v = arr[1];
			int w = arr[2];

			if (result[u] != (int) Math.pow(10, 8) && w + result[u] < result[v]) {
				return new int[] { -1 };
			}
		}

		return result;
	}
}
