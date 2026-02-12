package leetcode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
		int source = 1;
		int target = 6;
		System.out.println(numBusesToDestination(routes, source, target));
	}

	public static int numBusesToDestination(int[][] routes, int source, int target) {
		if (source == target)
			return 0;

		int m = routes.length;
		HashMap<Integer, List<Integer>> map = new HashMap<>();
		Queue<Integer> pq = new LinkedList<>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < routes[i].length; j++) {
				if (!map.containsKey(routes[i][j]))
					map.put(routes[i][j], new ArrayList<>());

				map.get(routes[i][j]).add(i);
			}
		}

		if (!map.containsKey(source))
			return -1;
		;

		boolean[] visited = new boolean[m];
		for (int startBus : map.get(source)) {
			pq.add(startBus);
			visited[startBus] = true;
		}

		int count = 1;
		while (!pq.isEmpty()) {
			int N = pq.size();
			while (N-- > 0) {
				int rv = pq.remove();

				for (int stops : routes[rv]) {
					if (stops == target)
						return count;

					for (int nextBus : map.get(stops)) {
						if (!visited[nextBus]) {
							visited[nextBus] = true;
							pq.add(nextBus);
						}
					}
				}
			}
			count++;
		}

		return -1;
	}
}
