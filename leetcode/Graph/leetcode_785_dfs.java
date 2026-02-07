package leetcode.Graph;

import java.util.Arrays;

public class leetcode_785_dfs {

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
				if (dfs(graph, i, color, 1) == false)
					return false;
			}
		}
		return true;
	}

	private static boolean dfs(int[][] graph, int currNode, int[] color, int currColor) {
		color[currNode] = currColor;

		for (int v : graph[currNode]) {
			if (color[v] == currColor)
				return false;

			if (color[v] == -1) {
				int colorv = 1 - currColor;
				if (dfs(graph, v, color, colorv) == false)
					return false;
			}

		}
		return true;
	}
}
