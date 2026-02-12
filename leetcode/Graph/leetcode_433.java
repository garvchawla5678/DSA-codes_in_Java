package leetcode.Graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class leetcode_433 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String startGene = "AACCGGTT";
		String endGene = "AAACGGTA";
		String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		System.out.println(minMutation(startGene, endGene, bank));
	}

	public static int minMutation(String startGene, String endGene, String[] bank) {
		Set<String> st = new HashSet<>();
		for (String str : bank)
			st.add(str);

		if (!st.contains(endGene))
			return -1;

		char[] arr = new char[4];
		arr[0] = 'A';
		arr[1] = 'C';
		arr[2] = 'G';
		arr[3] = 'T';

		Queue<String> pq = new LinkedList<>();
		pq.add(startGene);
		int level = 0;

		while (!pq.isEmpty()) {
			int N = pq.size();

			while (N-- > 0) {
				String curr = pq.remove();
				if (curr.equals(endGene))
					return level;

				char[] temp = curr.toCharArray();
				for (int i = 0; i < curr.length(); i++) {
					char old = temp[i];
					for (int j = 0; j < 4; j++) {
						temp[i] = arr[j];
						String isInBank = new String(temp);
						if (st.contains(isInBank)) {
							pq.add(isInBank);
							st.remove(isInBank);
						}
					}
					temp[i] = old;
				}
			}
			level++;
		}

		return -1;
	}
}
