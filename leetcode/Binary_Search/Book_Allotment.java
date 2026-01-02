package leetcode.Binary_Search;

import java.util.Arrays;

public class Book_Allotment {
    static void main() {
        int[] arr = { 10, 20, 30, 40 };
        int students = 2;
        Arrays.sort(arr);
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println(min_no_of_pages(arr, students, sum));
    }

    public static int min_no_of_pages(int[] arr, int n, int total_pages) {
        int ans = 0;
        int low = 0;
        int high = total_pages;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isItPossible(arr, n, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isItPossible(int[] arr, int n, int mid) {
        int student = 1;
        int read_pages = 0;
        for (int i = 0; i < arr.length; i++) {
            if (read_pages + arr[i] <= mid) {
                read_pages += arr[i];
            } else {
                student++;
                read_pages = arr[i];
            }
            if (student > n) {
                return false;
            }
        }
        return true;
    }
}
