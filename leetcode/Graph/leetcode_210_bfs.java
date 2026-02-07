package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_210_bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[][] edges = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		System.out.println(Arrays.toString(findOrder(n, edges)));
	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		List<List<Integer>> map = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			map.add(new ArrayList<>());
		}

		for (int[] arr : prerequisites) {
			map.get(arr[1]).add(arr[0]);
			indegree[arr[0]]++;
		}

		int[] ans = new int[numCourses];
		int j = 0;
		Queue<Integer> pq = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				pq.add(i);
				ans[j++] = i;
			}
		}

		while (!pq.isEmpty()) {
			int u = pq.remove();

			for (int v : map.get(u)) {
				indegree[v]--;
				if (indegree[v] == 0) {
					pq.add(v);
					ans[j++] = v;
				}

			}
		}
		return j < numCourses ? new int[] {} : ans;
	}
}
