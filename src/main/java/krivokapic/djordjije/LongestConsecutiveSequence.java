package krivokapic.djordjije;


import java.util.Set;
import java.util.HashSet;


// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> numbers = new HashSet<>();

        for (int number : nums) {
            numbers.add(number);
        }

        for (int index = 0; index < nums.length; index++) {
            int sequenceLength = 1;
            int currentNumber = nums[index];

            if (numbers.contains(currentNumber - 1)) {
                continue;
            }

            while (numbers.contains(currentNumber + 1)) {
                sequenceLength +=1;
                currentNumber += 1;
            }

            if (sequenceLength > result) {
                result = sequenceLength;
            }
        }

        return result;
    }

}
