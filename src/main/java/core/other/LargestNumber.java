package core.other;


import java.util.Arrays;
import java.util.stream.Collectors;


// https://leetcode.com/problems/largest-number/description/
// Time Complexity: O(n*log(n))
// Space Complexity: O(n)
public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (Arrays.stream(nums).allMatch(num -> num == 0)) {
            return "0";
        }

        return Arrays.stream(nums).mapToObj(String::valueOf).sorted((o1, o2) -> {
            if ((o1 + o2).compareTo(o2 + o1) < 0) {
                return -1;
            } else {
                return 1;
            }
        }).collect(Collectors.joining(""));
    }

}
