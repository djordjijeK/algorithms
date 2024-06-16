package krivokapic.djordjije;

import java.util.ArrayList;
import java.util.List;


// https://leetcode.com/problems/summary-ranges/description/
public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        int i = 0;
        while (i < nums.length) {
            String res = Integer.toString(nums[i]);

            int j = i;
            while (j < nums.length) {
                if (j == nums.length - 1 || nums[j] + 1 != nums[j + 1]) {
                    result.add(i == j ? res : res + "->" + nums[j]);
                    break;
                }

                j++;
            }

            i = j + 1;
        }

        return result;
    }

}
