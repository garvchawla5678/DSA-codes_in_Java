package leetcode.Graph;

import java.util.PriorityQueue;

public class leetocde_1584_Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = { { 0, 0 }, { 2, 2 }, { 3, 10 }, { 5, 2 }, { 7, 0 } };
		System.out.println(minCostConnectPoints(points));
	}

	public static int minCostConnectPoints(int[][] points) {
		int m = points.length;

		int sum = 0;
		int pointsConnected = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		pq.add(new int[] { 0, 0 });
		boolean[] visited = new boolean[m];

		while (pointsConnected < m) {
			int[] curr = pq.poll();
			int point = curr[0];
			int weight = curr[1];

			if (visited[point])
				continue;

			sum += weight;
			visited[point] = true;
			pointsConnected++;

			for (int nextPoint = 0; nextPoint < m; nextPoint++) {
				int[] point1 = points[point];
				int[] point2 = points[nextPoint];
				if (!visited[nextPoint]) {
					int dist = distance(point1, point2);
					pq.add(new int[] { nextPoint, dist });
				}
			}
		}

		return sum;
	}

	private static int distance(int[] point1, int[] point2) {
		return (int) Math.abs(point1[0] - point2[0]) + Math.abs(point1[1] - point2[1]);
	}
}
