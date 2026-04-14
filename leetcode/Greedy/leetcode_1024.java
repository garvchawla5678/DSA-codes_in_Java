package leetcode.Greedy;

import java.util.Arrays;

public class leetcode_1024 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] clips = { { 0, 1 }, { 6, 8 }, { 0, 2 }, { 5, 6 }, { 0, 4 }, { 0, 3 }, { 6, 7 }, { 1, 3 }, { 4, 7 },
				{ 1, 4 }, { 2, 5 }, { 2, 6 }, { 3, 4 }, { 4, 5 }, { 5, 7 }, { 6, 9 } };
		int time = 9;
		System.out.println(videoStitching(clips, time));
	}

	public static int videoStitching(int[][] clips, int time) {
//		Arrays.sort(clips, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
//		int n = clips.length;
//		int res = 0;
//		int i = 0;
//		int currentEnd = 0;
//		int farthestEnd = 0;
//		while (currentEnd < time) {
//			while (i < n && clips[i][0] <= currentEnd) {
//				farthestEnd = Math.max(farthestEnd, clips[i][1]);
//				i++;
//			}
//			if (farthestEnd == currentEnd)
//				return -1;
//			res++;
//			currentEnd = farthestEnd;
//		}
//		return res;

		// Approach - 2
		int[] maxReach = new int[time + 1];
		int n = clips.length;
		for (int i = 0; i < n; i++) {
			int startTime = clips[i][0];
			if (startTime > time)
				continue;

			int endTime = Math.min(time, clips[i][1]);
			maxReach[startTime] = Math.max(maxReach[startTime], endTime);
		}
		System.out.println(Arrays.toString(maxReach));

		int l = 0;
		int r = 0;
		int clipsCount = 0;

		while (r < time) {
			int farthest = 0;
			for (int k = l; k <= r; k++) {
				farthest = Math.max(farthest, maxReach[k]);
			}
			if (farthest <= r)
				return -1;

			l = r + 1;
			r = farthest;
			clipsCount++;
		}

		return clipsCount;
	}
}
