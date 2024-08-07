package krivokapic.djordjije.binarysearch;


public class FirstBadVersion {
    // https://leetcode.com/problems/first-bad-version/description/
    // Time Complexity: O(log n)
    // Space Complexity: O(1)
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            boolean isBadVersion = isBadVersion(mid);

            if (isBadVersion) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    boolean isBadVersion(int version) {
        return true;
    }
}
