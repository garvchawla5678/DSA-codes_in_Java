package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3;
		int[][] edges = { { 0, 1, 1 }, { 1, 2, 3 }, { 0, 2, 6 } };
		int src = 2;
		System.out.println(Arrays.toString(dijkstra(V, edges, src)));
	}

	public static int[] dijkstra(int V, int[][] edges, int src) {
		int[] result = new int[V];
		Arrays.fill(result, Integer.MAX_VALUE);

		HashMap<Integer, List<int[]>> map = new HashMap<>();
		for (int[] arr : edges) {
			if (!map.containsKey(arr[0]))
				map.put(arr[0], new ArrayList<>());
			if (!map.containsKey(arr[1]))
				map.put(arr[1], new ArrayList<>());
			map.get(arr[0]).add(new int[] { arr[1], arr[2] });
			map.get(arr[1]).add(new int[] { arr[0], arr[2] });
		}

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		result[src] = 0;
		pq.add(new int[] { 0, src });
		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int d = temp[0];
			int node = temp[1];

			if (d > result[node])
				continue;

			for (int[] v : map.get(node)) {
				int dist = v[1];
				int n = v[0];
				if (d + dist < result[n]) {
					result[n] = d + dist;
					pq.add(new int[] { d + dist, n });
				}
			}
		}

		return result;
	}
}
