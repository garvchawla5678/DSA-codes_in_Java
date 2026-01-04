package leetcode.Binary_Search;

public class leetcode_4_optimized {
    static void main() {
        int[] arr1 = { 1, 2 };
        int[] arr2 = { 3, 4 };
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;

        int l = 0;
        int r = m;
        while (l <= r) {
            int Px = l + (r - l) / 2; // mid -> nums1
            int Py = (m + n + 1) / 2 - Px; // elements from nums2 on left side

            // left side waale
            int x1 = (Px == 0) ? Integer.MIN_VALUE : nums1[Px - 1];
            int x2 = (Py == 0) ? Integer.MIN_VALUE : nums2[Py - 1];

            // right side waale
            int x3 = (Px == m) ? Integer.MAX_VALUE : nums1[Px];
            int x4 = (Py == n) ? Integer.MAX_VALUE : nums2[Py];

            if (x1 <= x4 && x2 <= x3) {
                if ((m + n) % 2 == 1) {
                    return Math.max(x1, x2);
                }
                return (Math.max(x1, x2) + Math.min(x3, x4)) / 2.0;
            }
            if (x1 > x4) {
                r = Px - 1;
            } else {
                l = Px + 1;
            }
        }
        return -1;
    }
}
