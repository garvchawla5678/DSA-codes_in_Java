package leetcode.Graph;

public class leetcode_1361 {

	static int[] parent;
	static int component;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int[] leftChild = { 1, -1, 3, -1 };
		int[] rightChild = { 2, -1, -1, -1 };
		System.out.println(validateBinaryTreeNodes(n, leftChild, rightChild));
	}

	public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		component = n;
		parent = new int[n];
		for (int i = 0; i < n; i++)
			parent[i] = i;

		for (int i = 0; i < n; i++) {
			int node = i;
			int lc = leftChild[i];
			int rc = rightChild[i];

			if (lc != -1 && union(node, lc) == false)
				return false;

			if (rc != -1 && union(node, rc) == false)
				return false;
		}

		return component == 1;
	}

	private static int find(int u) {
		if (u == parent[u])
			return u;
		return parent[u] = find(parent[u]);
	}

	private static boolean union(int node, int child) {
		int parent_node = find(node);
		int child_parent = find(child);

		if (child_parent != child)
			return false;

		// kind of checking for cycle in tree
		if (parent_node == child)
			return false;

		parent[child] = node;
		component--;
		return true;
	}
}
