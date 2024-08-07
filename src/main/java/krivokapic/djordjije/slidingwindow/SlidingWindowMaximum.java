package krivokapic.djordjije.slidingwindow;


import java.util.ArrayDeque;


public class SlidingWindowMaximum {
    // https://leetcode.com/problems/sliding-window-maximum/description/
    // Time Complexity: O(n)
    // Space Complexity: O(k)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;

        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int i = 0;
        while (right < nums.length) {

            while (!deque.isEmpty() && nums[deque.getLast()] < nums[right]) {
                deque.pollLast();
            }
            deque.addLast(right);

            if (left > deque.getFirst()) {
                deque.pollFirst();
            }

            if (right - left + 1 == k) {
                result[i++] = nums[deque.peekFirst()];
                left++;
            }

            right++;
        }

        return result;
    }
}
