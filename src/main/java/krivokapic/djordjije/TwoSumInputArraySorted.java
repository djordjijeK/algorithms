package krivokapic.djordjije;


// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class TwoSumInputArraySorted {

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int leftIndex = 0;
        int rightIndex = numbers.length - 1;

        while (leftIndex < rightIndex) {
            if (numbers[leftIndex] + numbers[rightIndex] > target) {
                rightIndex -= 1;
            } else if (numbers[leftIndex] + numbers[rightIndex] < target) {
                leftIndex += 1;
            } else {
                result[0] = leftIndex + 1;
                result[1] = rightIndex + 1;
                break;
            }
        }

        return result;
    }

}
