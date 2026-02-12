package leetcode.Graph;

import java.util.ArrayList;

public class Euler_Path_And_Circuit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(0);
		adj.get(1).add(2);
		adj.get(2).add(0);
		adj.get(2).add(1);
		int V = 3;
		System.out.println(isEulerCircuit(V, adj));
	}

	public static int isEulerCircuit(int V, ArrayList<ArrayList<Integer>> adj) {
		// check if all non-zero degree vertices are part of one component
		if (isConnected(V, adj) == false)
			return 0;

		int oddDegree = 0;
		for (int i = 0; i < V; i++) {
			if (adj.get(i).size() % 2 != 0)
				oddDegree++;
		}

		if (oddDegree > 2)
			return 0;

		if (oddDegree == 2)
			return 1;

		return 2;
	}

	private static boolean isConnected(int V, ArrayList<ArrayList<Integer>> adj) {
		int nonZeroVertex = -1;
		for (int i = 0; i < V; i++) {
			if (adj.get(i).size() != 0) {
				nonZeroVertex = i;
				break;
			}
		}

		boolean[] visited = new boolean[V];
		dfs(nonZeroVertex, adj, visited);

		for (int i = 0; i < V; i++) {
			if (visited[i] == false && adj.get(i).size() != 0)
				return false;
		}

		return true;
	}

	private static void dfs(int nonZeroVertex, ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
		visited[nonZeroVertex] = true;

		for (int v : adj.get(nonZeroVertex)) {
			if (!visited[v])
				dfs(v, adj, visited);
		}
	}
}
