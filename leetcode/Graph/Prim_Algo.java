package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Prim_Algo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 3;
		int[][] edges = { { 0, 1, 5 }, { 1, 2, 3 }, { 0, 2, 1 } };
		System.out.println(spanningTree(V, edges));
	}

	public static int spanningTree(int V, int[][] edges) {
		HashMap<Integer, List<int[]>> map = new HashMap<>();
		for (int[] arr : edges) {
			if (!map.containsKey(arr[0]))
				map.put(arr[0], new ArrayList<>());
			if (!map.containsKey(arr[1]))
				map.put(arr[1], new ArrayList<>());

			map.get(arr[0]).add(new int[] { arr[1], arr[2] });
			map.get(arr[1]).add(new int[] { arr[0], arr[2] });
		}

		boolean[] inMst = new boolean[V];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] { edges[0][0], 0 });

		int sum = 0;
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int node = curr[0];
			int weight = curr[1];
			if (inMst[node])
				continue;

			sum += weight;
			inMst[node] = true;

			for (int[] v : map.get(node)) {
				int w = v[1];
				int next = v[0];

				if (!inMst[next]) {
					pq.add(new int[] { next, w });
				}
			}
		}

		return sum;
	}
}
