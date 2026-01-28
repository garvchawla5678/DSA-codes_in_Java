package leetcode.Heap;

public class leetcode_621_opti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] arr = { 'A', 'A', 'A', 'B', 'B', 'B' };
		int k = 2;
		System.out.println(leastInterval(arr, k));
	}

	// Using Greedy Approach
	public static int leastInterval(char[] tasks, int n) {
//		int[] arr = new int[27];
//		for (char ch : tasks) {
//			arr[ch - 'A']++;
//		}
//
//		Arrays.sort(arr);
//
//		int maxFreq = arr[26];
//		int gaddha = maxFreq - 1;
//		int iddle_spots = n * gaddha;
//
//		for (int i = 25; i >= 0; i--) {
//			iddle_spots = iddle_spots - Math.min(gaddha, arr[i]);
//		}
//
//		if (iddle_spots > 0)
//			return tasks.length + iddle_spots;
//		return tasks.length;

		// We can also do this using direct formula which is kind of similar to above
		// approach if we see carefully
		int[] arr = new int[27];
		for (char ch : tasks) {
			arr[ch - 'A']++;
		}
		int maxFreq = 0;
		for (int num : arr) {
			maxFreq = Math.max(maxFreq, num);
		}

		int count_maxFreq = 0;
		for (int num : arr) {
			if (num == maxFreq)
				count_maxFreq++;
		}

		return Math.max(tasks.length, ((maxFreq - 1) * (n + 1)) + count_maxFreq);
	}
}
