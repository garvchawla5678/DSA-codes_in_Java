package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class leetcode_2097 {

	// Euler's Path( Heirholzer's Algorithm)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 5, 1 }, { 4, 5 }, { 11, 9 }, { 9, 4 } };
		int[][] temp = validArrangement(points);
		for (int[] arr : temp) {
			System.out.print(Arrays.toString(arr) + ", ");
		}
		System.out.println();
	}

	public static int[][] validArrangement(int[][] pairs) {
		int m = pairs.length;

		// build graph
		HashMap<Integer, List<Integer>> map = new HashMap<>();

		// build indegree and outdegree
		HashMap<Integer, Integer> indegree = new HashMap<>();
		HashMap<Integer, Integer> outdegree = new HashMap<>();
		for (int[] arr : pairs) {
			indegree.put(arr[0], 0);
			outdegree.put(arr[0], 0);

			indegree.put(arr[1], 0);
			outdegree.put(arr[1], 0);
		}

		for (int[] arr : pairs) {
			int u = arr[0];
			int v = arr[1];

			if (!map.containsKey(u))
				map.put(u, new ArrayList<>());

			map.get(u).add(v);
			indegree.put(v, indegree.get(v) + 1);
			outdegree.put(u, outdegree.get(u) + 1);
		}

		int startNode = pairs[0][0];
		for (int u : map.keySet()) {
			if (outdegree.get(u) - indegree.get(u) == 1) {
				startNode = u;
				break;
			}
		}

		Stack<Integer> st = new Stack<>(); // to perform dfs
		List<Integer> eulerPath = new ArrayList<>(); // to store euler's path
		st.push(startNode);

		while (!st.isEmpty()) {
			int curr = st.peek();
			if (map.get(curr) != null && !map.get(curr).isEmpty()) {
				int neigh = map.get(curr).getLast();
				map.get(curr).removeLast();
				st.push(neigh);
			} else {
				eulerPath.add(st.pop());
			}

		}

		// build your result
		Collections.reverse(eulerPath);
		int[][] result = new int[m][2];
		for (int i = 0; i < eulerPath.size() - 1; i++) {
			result[i][0] = eulerPath.get(i);
			result[i][1] = eulerPath.get(i + 1);
		}

		return result;
	}
}
