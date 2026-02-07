package leetcode.Graph;

import java.util.ArrayList;
import java.util.List;

public class leetcode_207_dfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int[][] edges = { { 1, 0 }, { 0, 1 } };
		System.out.println(canFinish(n, edges));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		List<List<Integer>> map = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			map.add(new ArrayList<>());
		}

		for (int[] arr : prerequisites) {
			map.get(arr[1]).add(arr[0]);
		}
		boolean[] visited = new boolean[numCourses];
		boolean[] inRecursion = new boolean[numCourses];

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i] && bfs(map, i, visited, inRecursion))
				return false;
		}
		return true;
	}

	private static boolean bfs(List<List<Integer>> map, int u, boolean[] visited, boolean[] inRecursion) {
		visited[u] = true;
		inRecursion[u] = true;

		for (int v : map.get(u)) {
			if (visited[v] == false && bfs(map, v, visited, inRecursion))
				return true;
			else if (inRecursion[v])
				return true;
		}
		inRecursion[u] = false;
		return false;
	}
}
