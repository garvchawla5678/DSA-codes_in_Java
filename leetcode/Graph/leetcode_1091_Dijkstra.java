package leetcode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class leetcode_1091_Dijkstra {

	class Pair {
		int d;
		int[] coord;

		Pair(int n, int[] arr) {
			this.d = n;
			this.coord = arr;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
		leetcode_1091_Dijkstra cl = new leetcode_1091_Dijkstra();
		System.out.println(cl.shortestPathBinaryMatrix(grid));
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, 1 }, { 1, -1 }, { -1, -1 } };

		if (m == 0 || n == 0 || grid[0][0] != 0)
			return -1;

		// here we are not using PriorityQueue for keeping track of smallest distance
		// because here weight(travel distance) is same for each travel so while
		// traversing from one node to another(in this case cell) the distance of all
		// other nodes will be same this is also the reason why we are able to solve
		// this question using bfs also.

		Queue<Pair> pq = new LinkedList<>();
		grid[0][0] = 1; // visited
		pq.add(new Pair(0, new int[] { 0, 0 }));

		int[][] result = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = Integer.MAX_VALUE;
			}
		}
		result[0][0] = 0;

		while (!pq.isEmpty()) {
			Pair temp = pq.remove();
			int d = temp.d;
			int[] coord = temp.coord;

			int x = coord[0];
			int y = coord[1];

			for (int[] arr : directions) {
				int new_x = x + arr[0];
				int new_y = y + arr[1];
				if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n)
					continue;

				int dist = 1;

				if (grid[new_x][new_y] == 0 && d + dist < result[new_x][new_y]) {
					result[new_x][new_y] = d + dist;
					pq.add(new Pair(d + dist, new int[] { new_x, new_y }));
					grid[new_x][new_y] = 1;
				}
			}

		}
		if (result[m - 1][n - 1] == Integer.MAX_VALUE)
			return -1;

		return result[m - 1][n - 1] + 1;
	}
}
