package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Shortest_Path_In_Undirected_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int m = 6;
		int[][] edges = { { 1, 2, 2 }, { 2, 5, 5 }, { 2, 3, 4 }, { 1, 4, 1 }, { 4, 3, 3 }, { 3, 5, 1 } };
		System.out.println(shortestPath(n, m, edges));
	}

	public static List<Integer> shortestPath(int n, int m, int edges[][]) {
		HashMap<Integer, List<int[]>> map = new HashMap<>();
		for (int[] arr : edges) {
			if (!map.containsKey(arr[0]))
				map.put(arr[0], new ArrayList<>());
			if (!map.containsKey(arr[1]))
				map.put(arr[1], new ArrayList<>());
			map.get(arr[0]).add(new int[] { arr[1], arr[2] });
			map.get(arr[1]).add(new int[] { arr[0], arr[2] });
		}

		int[] result = new int[n + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		int[] parent = new int[n + 1];
		for (int i = 1; i <= n; i++)
			parent[i] = i;

		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		result[1] = 0;
		pq.add(new int[] { 0, 1 });

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int d = temp[0];
			int node = temp[1];

			if (d > result[node])
				continue;

			for (int[] v : map.get(node)) {
				int dist = v[1];
				int v_node = v[0];
				if (d + dist < result[v_node]) {
					result[v_node] = d + dist;
					parent[v_node] = node;
					pq.add(new int[] { d + dist, v_node });
				}
			}
		}
		int node = n;
		List<Integer> ans = new ArrayList<>();

		if (result[node] == Integer.MAX_VALUE) {
			ans.add(-1);
			return ans;
		}

		ans.add(node);
		while (parent[node] != node) {
			ans.add(parent[node]);
			node = parent[node];
		}

		Collections.reverse(ans);
		List<Integer> ans1 = new ArrayList<>();
		ans1.add(result[n]);
		ans1.addAll(ans);

		return ans1;
	}
}
