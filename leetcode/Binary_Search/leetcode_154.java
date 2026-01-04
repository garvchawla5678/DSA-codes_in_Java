package leetcode.Binary_Search;

public class leetcode_154 {
    static void main() {
        int[] arr = { 2, 9, 2, 2, 2, 2, 2 };
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] nums) {
        int pivot = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mid < end && nums[mid] > nums[mid + 1]) {
                pivot = mid;
                break;
            }
            if (mid > start && nums[mid] < nums[mid - 1]) {
                pivot = mid - 1;
                break;
            }

            if(nums[start] == nums[mid] && nums[mid] == nums[end]){
                if(nums[start] > nums[start + 1]){
                    return nums[start + 1];
                }
                start++;
                if(nums[end] <  nums[end - 1]){
                    return nums[end];
                }
                end--;
            } else if(nums[start] < nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[pivot + 1];
    }
}
