package krivokapic.djordjije;


// https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;

        int leftIndex = 0;
        int rightIndex = height.length - 1;

        while (leftIndex <= rightIndex) {
            if (maxArea < Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex)) {
                maxArea = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);
            }

            if (height[leftIndex] <= height[rightIndex]) {
                leftIndex += 1;
            } else {
                rightIndex -= 1;
            }
        }

        return maxArea;
    }

}
