package leetcode.Graph;

public class leetcode_990 {

	static int[] rank;
	static int[] parent;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(equationsPossible(new String[] { "a==b", "b!=a" }));
	}

	public static boolean equationsPossible(String[] equations) {
		parent = new int[26];
		rank = new int[26];
		for (int i = 0; i < 26; i++) {
			parent[i] = i;
			rank[i] = 0;
		}

		for (String eq : equations) {
			if (eq.charAt(1) == '=') {
				int a = eq.charAt(0) - 'a';
				int b = eq.charAt(3) - 'a';

				union(a, b);
			}
		}

		for (String eq : equations) {
			if (eq.charAt(1) == '!') {
				int a = find(eq.charAt(0) - 'a');
				int b = find(eq.charAt(3) - 'a');

				if (a == b)
					return false;
			}
		}

		return true;
	}

	private static void union(int u, int v) {
		int u_parent = find(u);
		int v_parent = find(v);

		if (u_parent == v_parent)
			return;

		if (rank[u_parent] > rank[v_parent]) {
			parent[v_parent] = u_parent;
		} else if (rank[u_parent] < rank[v_parent]) {
			parent[u_parent] = v_parent;
		} else {
			parent[u_parent] = v_parent;
			rank[v_parent] += 1;
		}
	}

	private static int find(int u) {
		if (u == parent[u])
			return u;
		return parent[u] = find(parent[u]);
	}
}
