package krivokapic.djordjije;


import java.util.Map;
import java.util.HashMap;


// https://leetcode.com/problems/two-sum/description/
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> reminders = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            if (reminders.containsKey(nums[index])) {
                result[0] = reminders.get(nums[index]);
                result[1] = index;
                break;
            }

            reminders.put(target - nums[index], index);
        }

        return result;
    }

}
