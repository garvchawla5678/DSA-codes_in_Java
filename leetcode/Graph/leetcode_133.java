package leetcode.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_133 {

	// Definition for a Node.
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	class Solution {
		public Node cloneGraph(Node node) {
			if (node == null)
				return null;

			// HashMap<Node, Node> map = new HashMap<>();
			Queue<Node> pq = new LinkedList<>();
			pq.add(node);
			Node[] map = new Node[101];
			Node clone_node = new Node(node.val);
			map[node.val] = clone_node;
			dfs(node, clone_node, map);
			bfs(pq, map);

			return clone_node;
		}

		private void dfs(Node orgNode, Node clNode, Node[] map) {
			for (Node adj : orgNode.neighbors) {
				if (map[adj.val] == null) {
					Node clone = new Node(adj.val);
					map[adj.val] = clone;
					clNode.neighbors.add(clone);
					dfs(adj, clone, map);
				} else {
					clNode.neighbors.add(map[adj.val]);
				}
			}
		}

		private void bfs(Queue<Node> pq, Node[] map) {
			while (!pq.isEmpty()) {
				Node orgNode = pq.remove();
				Node clNode = map[orgNode.val];

				for (Node adj : orgNode.neighbors) {
					if (map[adj.val] == null) {
						Node clone = new Node(adj.val);
						map[adj.val] = clone;
						clNode.neighbors.add(clone);
						pq.add(adj);
					} else {
						clNode.neighbors.add(map[adj.val]);
					}
				}
			}
		}
	}

}
