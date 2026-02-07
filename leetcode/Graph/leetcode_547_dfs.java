package leetcode.Graph;

public class leetcode_547_dfs {

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
				dfs(isConnected, i, visited);
				count++;
			}
		}

		return count;
	}

	private static void dfs(int[][] isConnected, int u, boolean[] visited) {
		if (u > n)
			return;

		visited[u] = true;

		for (int v = 1; v <= n; v++) {
			if (!visited[v] && isConnected[u - 1][v - 1] == 1)
				dfs(isConnected, v, visited);
		}
	}

}
