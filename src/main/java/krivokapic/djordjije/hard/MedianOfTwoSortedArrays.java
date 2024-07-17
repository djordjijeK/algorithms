package krivokapic.djordjije.hard;


// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// Time Complexity: O(log(min(n,m))
// Space Complexity: O(1)
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // swap partitions so that first partition always contains fewer elements compared to second
        int[] firstPartition = nums1.length > nums2.length ? nums2 : nums1;
        int[] secondPartition = nums1.length > nums2.length ? nums1 : nums2;

        // calculate entire array length and array half
        int arrayLength = firstPartition.length + secondPartition.length;
        int arrayHalf = (arrayLength + 1) / 2;

        int left = 0;
        int right = firstPartition.length;
        while (true) {
            int i = (left + right) / 2;    // pointer in first partition
            int j = arrayHalf - i;         // pointer in second partition

            // split each partition further into left and right part
            int firstPartitionLeft = i > 0 ? firstPartition[i - 1] : Integer.MIN_VALUE;
            int firstPartitionRight = i < firstPartition.length ? firstPartition[i] : Integer.MAX_VALUE;
            int secondPartitionLeft = j > 0 ? secondPartition[j - 1] : Integer.MIN_VALUE;
            int secondPartitionRight = j < secondPartition.length ? secondPartition[j] : Integer.MAX_VALUE;

            // check if entire array is split correctly into left and right half
            // or else adjust i and j pointers
            if (firstPartitionLeft <= secondPartitionRight && secondPartitionLeft <= firstPartitionRight) {
                // finally, calculate median
                if (arrayLength % 2 == 0) {
                    return (double) (Math.max(firstPartitionLeft, secondPartitionLeft) + Math.min(firstPartitionRight, secondPartitionRight)) / 2;
                }

                return Math.max(firstPartitionLeft, secondPartitionLeft);
            } else if (firstPartitionLeft > secondPartitionRight) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
    }

}
