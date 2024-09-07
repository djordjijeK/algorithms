package core.binarysearch;

public class KokoEatingBananas {
    // https://leetcode.com/problems/koko-eating-bananas/description/
    // Time Complexity: O(n * log m)
    // Space Complexity: O(1)
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }


    private boolean canEatAll(int[] piles, int k, int h) {
        long totalTime = 0;
        for (int pile : piles) {
            totalTime += (pile - 1) / k + 1;

            if (totalTime > h) {
                return false;
            }
        }
        return true;
    }
}
