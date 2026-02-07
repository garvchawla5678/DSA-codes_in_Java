package leetcode.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class leetcode_785_bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grpah = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
		System.out.println(isBipartite(grpah));
	}

	public static boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] color = new int[n];

		Arrays.fill(color, -1);

		for (int i = 0; i < n; i++) {
			if (color[i] == -1) {
				if (bfs(graph, i, color, 1) == false)
					return false;
			}
		}
		return true;
	}

	private static boolean bfs(int[][] graph, int currNode, int[] color, int currColor) {
		Queue<Integer> pq = new LinkedList<>();
		pq.add(currNode);
		color[currNode] = currColor;

		while (!pq.isEmpty()) {
			int u = pq.remove();

			for (int v : graph[u]) {
				if (color[v] == currColor)
					return false;

				if (color[v] == -1) {
					int colorv = 1 - currColor;
					if (bfs(graph, v, color, colorv) == false)
						return false;
				}
			}
		}

		return true;
	}
}
