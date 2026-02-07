package leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_207_bfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int[][] edges = { { 1, 0 }, { 0, 1 } };
		System.out.println(canFinish(n, edges));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		int[] indegree = new int[numCourses];
		List<List<Integer>> map = new ArrayList<>();

		for (int i = 0; i < numCourses; i++) {
			map.add(new ArrayList<>());
		}

		for (int[] arr : prerequisites) {
			map.get(arr[1]).add(arr[0]);
			indegree[arr[0]]++;
		}

		int count = 0;
		Queue<Integer> pq = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				pq.add(i);
				count++;
			}
		}

		while (!pq.isEmpty()) {
			int u = pq.remove();

			for (int v : map.get(u)) {
				indegree[v]--;
				if (indegree[v] == 0) {
					pq.add(v);
					count++;
				}

			}
		}

		return count == numCourses;
	}
}
