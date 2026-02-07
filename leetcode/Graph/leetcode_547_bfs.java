package leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_547_bfs {

	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		System.out.println(findCircleNum(edges));
	}

	public static int findCircleNum(int[][] isConnected) {
		n = isConnected.length;

		boolean[] visited = new boolean[n + 1];

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				bfs(isConnected, i, visited);
				count++;
			}
		}

		return count;
	}

	private static void bfs(int[][] isConnected, int u, boolean[] visited) {
		Queue<Integer> pq = new LinkedList<>();
		pq.add(u);
		visited[u] = true;

		while (!pq.isEmpty()) {
			int rv = pq.remove();

			for (int v = 1; v <= n; v++) {
				if (!visited[v] && isConnected[rv - 1][v - 1] == 1) {
					pq.add(v);
					visited[v] = true;
				}

			}
		}
	}
}
