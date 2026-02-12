package leetcode.Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class leetcode_332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> tickets = new ArrayList<>();
		for (int i = 0; i < 5; i++)
			tickets.add(new ArrayList<>());
		tickets.get(0).add("JFK");
		tickets.get(0).add("SFO");
		tickets.get(1).add("JFK");
		tickets.get(1).add("ATL");
		tickets.get(2).add("SFO");
		tickets.get(2).add("ATL");
		tickets.get(3).add("ATL");
		tickets.get(3).add("JFK");
		tickets.get(4).add("ATL");
		tickets.get(4).add("SFO");
		System.out.println(findItinerary(tickets));
	}

	public static List<String> findItinerary(List<List<String>> tickets) {
		HashMap<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> str : tickets) {
			String u = str.get(0);
			String v = str.get(1);
			if (!map.containsKey(u))
				map.put(u, new PriorityQueue<>());

			map.get(u).add(v);
		}

		List<String> ans = new ArrayList<>();
		Stack<String> st = new Stack<>();
		st.push("JFK");
		while (!st.isEmpty()) {
			String curr = st.peek();
			if (map.get(curr) != null && !map.get(curr).isEmpty()) {
				st.add(map.get(curr).poll());
			} else {
				ans.add(st.pop());
			}
		}

		Collections.reverse(ans);
		return ans;
	}
}
