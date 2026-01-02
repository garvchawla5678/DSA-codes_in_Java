package leetcode.Binary_Search;

public class leetcode_74 {
    static void main() {
        int[][] arr = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target = 60;
        System.out.println(searchMatrix(arr, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        boolean flag = false;
        int start = 0;
        int end = matrix.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] < target) {
                flag = search(target, matrix[mid], 0, matrix[0].length - 1) != -1;
                start = mid + 1;
            } else if (matrix[mid][0] > target) {
                end = mid - 1;
            }
        }
        return flag;
    }

    public static int search(int target, int[] arr, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}
