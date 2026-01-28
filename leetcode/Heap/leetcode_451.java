package leetcode.Heap;

import java.util.HashMap;
import java.util.PriorityQueue;

public class leetcode_451 {
	class Pair {
		char key;
		int frequency;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "cccaaa";
		leetcode_451 cl = new leetcode_451();
		System.out.println(cl.frequencySort(s));
	}

	public String frequencySort(String s) {
		char[] arr = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for (char ch : arr) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		Pair[] prr = new Pair[map.keySet().size()];
		int i = 0;
		for (char ch : map.keySet()) {
			prr[i] = new Pair();
			prr[i].key = ch;
			prr[i].frequency = map.get(ch);
			i++;
		}
		// 1 way to solve
//		Arrays.sort(prr, (a, b) -> Integer.compare(b.frequency, a.frequency));
//
//		StringBuilder ans = new StringBuilder();
//        for(int j = 0; j < prr.length; j++) {
//            Pair pr = prr[j];
//            int frq = pr.frequency;
//            if(frq == 0) break;
//            while (frq > 0) {
//				ans.append(pr.key);
//				frq--;
//			}
//        }
//		return ans.toString();

		PriorityQueue<Pair> qu = new PriorityQueue<>((a, b) -> Integer.compare(b.frequency, a.frequency));
		for (Pair pr : prr) {
			qu.add(pr);
		}
		StringBuilder ans = new StringBuilder();
		while (!qu.isEmpty()) {
			Pair pr = qu.poll();
			int frq = pr.frequency;
			while (frq > 0) {
				ans.append(pr.key);
				frq--;
			}
		}
		return ans.toString();
	}
}
