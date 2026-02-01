package leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
		// code here
		boolean[] visited = new boolean[adj.size()];
		ArrayList<Integer> ans = new ArrayList<>();
		bfs(adj, 0, visited, ans);
		return ans;
	}

	private static void bfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visited, ArrayList<Integer> ans) {
		Queue<Integer> pq = new LinkedList<>();
		pq.add(u);
		visited[u] = true;
		ans.add(u);

		while (!pq.isEmpty()) {
			int rv = pq.remove();

			for (int v : adj.get(rv)) {
				if (!visited[v]) {
					pq.add(v);
					visited[v] = true;
					ans.add(v);
				}
			}
		}
	}
}
