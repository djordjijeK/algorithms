package other;

public class FindTheStudentThatWillReplaceTheChalk {
    // https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int chalkReplacer(int[] chalk, int k) {
        int currentSum = 0;

        for (int i = 0; i < chalk.length; i++) {
            currentSum += chalk[i];
            if (currentSum > k) {
                return i;
            }
        }

        int rest = k % currentSum;
        int index = 0;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > rest) {
                index = i;
                break;
            }

            rest -= chalk[i];
        }

        return index;
    }
}
