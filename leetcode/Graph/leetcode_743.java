package leetcode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class leetcode_743 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int k = 2;
		int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
		System.out.println(networkDelayTime(times, n, k));
	}

	public static int networkDelayTime(int[][] times, int n, int k) {
		HashMap<Integer, List<int[]>> map = new HashMap<>();
		for (int[] arr : times) {
			if (!map.containsKey(arr[0]))
				map.put(arr[0], new ArrayList<>());
			map.get(arr[0]).add(new int[] { arr[1], arr[2] });
		}

		int[] result = new int[n + 1];
		Arrays.fill(result, Integer.MAX_VALUE);
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		result[k] = 0;
		pq.add(new int[] { 0, k });

		while (!pq.isEmpty()) {
			int[] temp = pq.poll();
			int d = temp[0];
			int node = temp[1];

			if (d > result[node])
				continue;
			if (!map.containsKey(node))
				continue;

			for (int[] v : map.get(node)) {
				int dist = v[1];
				int v_node = v[0];
				if (d + dist < result[v_node]) {
					result[v_node] = d + dist;
					pq.add(new int[] { d + dist, v_node });
				}
			}
		}

		int ans = -1;
		for (int i = 1; i <= n; i++) {
			ans = Math.max(ans, result[i]);
		}

		return ans == Integer.MAX_VALUE ? -1 : ans;
	}
}
