package arrays;

public class MergeSortedArray {
    // https://leetcode.com/problems/merge-sorted-array
    // Time Complexity: O(n + m)
    // Space Complexity: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int leftLastIndex = m - 1;
        int rightLastIndex = n - 1;
        int index = m + n - 1;

        while (leftLastIndex >= 0 && rightLastIndex >= 0) {
            if (nums1[leftLastIndex] > nums2[rightLastIndex]) {
                nums1[index] = nums1[leftLastIndex];
                leftLastIndex--;
            } else {
                nums1[index] = nums2[rightLastIndex];
                rightLastIndex--;
            }

            index--;
        }

        while (rightLastIndex >= 0) {
            nums1[index] = nums2[rightLastIndex];
            rightLastIndex--;
            index--;
        }
    }
}
