package leetcode.Heap;

import java.util.Random;

public class Kth_Largest_Element_IN_Array_opti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 3, 2, 1, 9, 6, 4 };
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}

	public static int findKthLargest(int[] nums, int k) {
		Random rn = new Random();
		int start = 0;
		int end = nums.length - 1;
		while (true) {
			int pivot_index = start + rn.nextInt(end - start + 1);
			int pivot = partition(nums, start, end, pivot_index);
			if (pivot == k - 1) {
				return nums[pivot];
			} else if (pivot > k - 1) {
				end = pivot - 1;
			} else {
				start = pivot + 1;
			}
		}
	}

	public static int partition(int[] nums, int start, int end, int pivot_index) {
		swap(nums, pivot_index, start);
		int pivot = start;
		int i = start + 1;
		int j = end;
		while (i <= j) {
			if (nums[i] < nums[pivot] && nums[j] > nums[pivot]) {
				swap(nums, i, j);
				i++;
				j--;
			}
			if (nums[i] >= nums[pivot])
				i++;
			if (nums[j] <= nums[pivot])
				j--;
		}
		swap(nums, pivot, j);
		return j;
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
