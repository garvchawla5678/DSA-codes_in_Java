package leetcode.Binary_Search;

public class leetcode_153 {
    static void main() {
        int[] arr = { 6, 7, 0, 1, 2, 4, 5 };
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] nums) {
        int pivot = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                pivot = mid;
                break;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                pivot = mid - 1;
                break;
            }
            if (nums[start] < nums[mid]) {
                start = mid;
            } else {
                end = mid - 1;
            }
        }
        return nums[pivot + 1];
    }
}
