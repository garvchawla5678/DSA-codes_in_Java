package leetcode.BitManipulation;

import java.util.Arrays;
import java.util.Comparator;

public class leetcode_1356 {

	class Pair {
		int n;
		int noOfSetBits;

		Pair(int n) {
			this.n = n;

//			int count = 0;
//			int x = this.n;
//			while (x != 0) {
//				x = x & (x - 1);
//				count++;
//			}

			this.noOfSetBits = Integer.bitCount(this.n);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
		leetcode_1356 cl = new leetcode_1356();
		System.out.println(Arrays.toString(cl.sortByBits(arr)));
	}

	public int[] sortByBits(int[] arr) {
		int m = arr.length;
		Pair[] prr = new Pair[m];
		for (int i = 0; i < m; i++) {
			prr[i] = new Pair(arr[i]);
		}

		Arrays.sort(prr, new Comparator<Pair>() {
			@Override
			public int compare(Pair a, Pair b) {
				if (a.noOfSetBits == b.noOfSetBits)
					return a.n - b.n;
				return a.noOfSetBits - b.noOfSetBits;
			}
		});

		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			ans[i] = prr[i].n;
		}

		return ans;
	}
}
