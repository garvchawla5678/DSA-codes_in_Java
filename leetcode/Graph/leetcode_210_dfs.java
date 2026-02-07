package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class leetcode_210_dfs {

	static boolean isCyclic;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] edges = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(Arrays.toString(findOrder(n, edges)));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		boolean[] visited = new boolean[numCourses];
		boolean[] inRecursion = new boolean[numCourses];
		List<List<Integer>> map = new ArrayList<>();
		isCyclic = false;

		for (int i = 0; i < numCourses; i++) {
			map.add(new ArrayList<>());
		}

		for (int[] arr : prerequisites) {
			map.get(arr[1]).add(arr[0]);
		}

		int[] ans = new int[numCourses];
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i])
				dfs(map, i, visited, st, inRecursion);
		}

		if (isCyclic)
			return new int[] {};

		int j = 0;
		while (!st.isEmpty()) {
			ans[j++] = st.pop();
		}

		return ans;
	}

	private static void dfs(List<List<Integer>> map, int u, boolean[] visited, Stack<Integer> st,
			boolean[] inRecursion) {
		visited[u] = true;
		inRecursion[u] = true;

		for (int v : map.get(u)) {
			if (inRecursion[v]) {
				isCyclic = true;
				return;
			}

			if (visited[v] == false)
				dfs(map, v, visited, st, inRecursion);
		}
		inRecursion[u] = false;
		st.push(u);
	}
}
