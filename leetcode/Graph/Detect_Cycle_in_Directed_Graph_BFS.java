package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Detect_Cycle_in_Directed_Graph_BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int[][] edges = { { 1, 3 }, { 2, 3 }, { 4, 1 }, { 4, 0 }, { 5, 0 }, { 5, 2 } };
		System.out.println(isCyclic(n, edges));
	}

	public static boolean isCyclic(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int[] arr : edges) {
			map.get(arr[0]).add(arr[1]);
		}

		int[] indegree = new int[n];
		for (int u : map.keySet()) {
			for (int v : map.get(u)) {
				indegree[v]++;
			}
		}

		Queue<Integer> pq = new LinkedList<>();
		int count = 0;

		for (int i = 0; i < n; i++) {
			if (indegree[i] == 0)
				pq.add(i);
		}

		while (!pq.isEmpty()) {
			int u = pq.remove();
			count++;

			for (int v : map.get(u)) {
				indegree[v]--;
				if (indegree[v] == 0)
					pq.add(v);
			}
		}

		if (count == n)
			return false;
		return true;
	}
}
