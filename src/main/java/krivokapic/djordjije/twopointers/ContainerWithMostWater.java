package krivokapic.djordjije.twopointers;


public class ContainerWithMostWater {
    // https://leetcode.com/problems/container-with-most-water/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = (right - left) * Math.min(height[right], height[left]);

        while (left < right) {
            int currentArea = (right - left) * Math.min(height[right], height[left]);
            if (currentArea > area) {
                area = currentArea;
            }

            if (height[left] <= height[right]) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return area;
    }
}
