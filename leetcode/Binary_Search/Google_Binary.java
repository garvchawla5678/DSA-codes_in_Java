package leetcode.Binary_Search;

import java.util.Arrays;

public class Google_Binary {
    static void main() {
        int[] arr = { 1, 5, 3, 4, 2 };
        int n = 3;
        Arrays.sort(arr);
        System.out.println(largest_min_dist(arr, n));
    }

    public static int largest_min_dist(int[] arr, int n) {
        int ans = 0;
        int start = arr[0];
        int last = arr[arr.length - 1];
        while (start <= last) {
            int mid = start + (last - start) / 2;
            if (isItPossible(arr, n, mid)) {
                ans = mid;
                start = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return ans;
    }

    public static boolean isItPossible(int[] arr, int n, int mid) {
        int pos = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pos >= mid) {
                count++;
                pos = arr[i];
            }
            if (count == n) {
                return true;
            }
        }
        return false;
    }
}
