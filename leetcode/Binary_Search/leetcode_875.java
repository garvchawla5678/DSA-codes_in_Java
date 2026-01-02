package leetcode.Binary_Search;

import java.util.Arrays;

public class leetcode_875 {
    static void main() {
        int[] arr = { 30, 11, 23, 4, 20 };
        int h = 5;
        System.out.println(minEatingSpeed(arr, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int ans = 0;
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (isItPossible(piles, h, mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }

    static boolean isItPossible(int[] piles, int h, int max) {
        long hoursNeeded = 0;
        for (int pile : piles) {
            hoursNeeded += (pile + max - 1) / max;
            if (hoursNeeded > h) {
                return false;
            }
        }
        return hoursNeeded <= h;
    }
}
