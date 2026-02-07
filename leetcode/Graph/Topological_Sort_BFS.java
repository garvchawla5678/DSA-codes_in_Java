package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Topological_Sort_BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edges = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };
		System.out.println(topologicalsort(n, edges));
	}

	// Kahn's Algorithm
	private static ArrayList<Integer> topologicalsort(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
		}

		// boolean[] visited = new boolean[n];
		int[] indegree = new int[n];
		for (int u : map.keySet()) {
			for (int v : map.get(u)) {
				indegree[v]++;
			}
		}

		ArrayList<Integer> ans = new ArrayList<>();
		Queue<Integer> pq = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0)
				pq.add(i);
		}

		while (!pq.isEmpty()) {
			int u = pq.remove();
			ans.add(u);

			for (int v : map.get(u)) {
				indegree[v]--;
				if (indegree[v] == 0)
					pq.add(v);
			}
		}

		return ans;
	}

}
