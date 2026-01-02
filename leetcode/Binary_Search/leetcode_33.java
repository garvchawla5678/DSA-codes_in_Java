package leetcode.Binary_Search;

public class leetcode_33 {
    static void main() {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(arr, target));
    }

    static int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int pivot = 0;
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
            if (nums[start] > nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int ans = search(target, nums, 0, pivot);
        if (ans == -1) {
            ans = search(target, nums, pivot + 1, nums.length - 1);
        }
        return ans;
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
