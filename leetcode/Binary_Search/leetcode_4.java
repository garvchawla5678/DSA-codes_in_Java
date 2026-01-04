package leetcode.Binary_Search;

public class leetcode_4 {
    static void main() {
        int[] arr1 = {};
        int[] arr2 = { 1 };
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Time Complexity: O(m + n)
        // Space Complexity: O(1)
        int m = nums1.length;
        int n = nums2.length;

        int i = 0;
        int j = 0;
        int k = 0;

        int size = m + n;
        int idx1 = size / 2 - 1;
        int element1 = -1;

        int idx2 = size / 2;
        int element2 = -1;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                if (idx1 == k) {
                    element1 = nums1[i];
                }
                if (idx2 == k) {
                    element2 = nums1[i];
                }
                i++;
            } else {
                if (idx1 == k) {
                    element1 = nums2[j];
                }
                if (idx2 == k) {
                    element2 = nums2[j];
                }
                j++;
            }
            k++;
        }
        while (i < m) {
            if (idx1 == k) {
                element1 = nums1[i];
            }
            if (idx2 == k) {
                element2 = nums1[i];
            }
            i++;
            k++;
        }
        while (j < n) {
            if (idx1 == k) {
                element1 = nums2[j];
            }
            if (idx2 == k) {
                element2 = nums2[j];
            }
            j++;
            k++;
        }
        if (size % 2 == 1) {
            return element2;
        }
        return (element1 + element2) / 2.0;
    }
}
