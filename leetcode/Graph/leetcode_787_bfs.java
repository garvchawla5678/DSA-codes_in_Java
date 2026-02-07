package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_787_bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int src = 0;
		int dst = 3;
		int k = 1;
		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
		leetcode_787_bfs cl = new leetcode_787_bfs();
		System.out.println(cl.findCheapestPrice(n, flights, src, dst, k));
	}

	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
		HashMap<Integer, List<int[]>> adj = new HashMap<>();
		for (int[] arr : flights) {
			if (!adj.containsKey(arr[0]))
				adj.put(arr[0], new ArrayList<>());

			adj.get(arr[0]).add(new int[] { arr[1], arr[2] });
		}

		Queue<int[]> pq = new LinkedList<>();
		pq.add(new int[] { src, 0 });
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);

		dist[src] = 0;

		int steps = 0;

		while (!pq.isEmpty() && steps <= k) {

			int N = pq.size();

			while (N-- > 0) {
				int[] cur = pq.poll();

				int node = cur[0];
				int cost = cur[1];

				if (!adj.containsKey(node))
					continue;

				for (int[] next : adj.get(node)) {
					int v = next[0];
					int c = next[1];

					int newCost = cost + c;

					if (newCost < dist[v]) {
						dist[v] = newCost;
						pq.add(new int[] { v, newCost });
					}
				}
			}
			steps++;
		}

		return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
	}
}
