package krivokapic.djordjije.graph.dfs;

public class TimeNeededToInformAllEmployees {
    // https://leetcode.com/problems/time-needed-to-inform-all-employees/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        int longestInformationPath = 0;

        for (int i = 0; i < informTime.length; i++) {
            if (informTime[i] != 0) {
                continue;
            }

            int informationLength = dfs(i, headID, manager, informTime, 0);
            if (informationLength > longestInformationPath) {
                longestInformationPath = informationLength;
            }
        }

        return longestInformationPath;
    }


    private int dfs(int employee, int headId, int[] manager, int[] informationTime, int sum) {
        if (employee == headId) {
            sum += informationTime[headId];
            return sum;
        }

        sum += informationTime[employee];
        return dfs(manager[employee], headId, manager, informationTime, sum);
    }
}
