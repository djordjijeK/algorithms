package tree;


public class StepByStepDirectionsFromABinaryTreeNodeToAnother {

    // https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDestination = new StringBuilder();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDestination);

        StringBuilder result = new StringBuilder();
        int commonLength = 0;

        while (
            commonLength < pathToStart.length() &&
            commonLength < pathToDestination.length() &&
            pathToStart.charAt(commonLength) == pathToDestination.charAt(commonLength)
        ) {
            commonLength++;
        }

        result.append("U".repeat(Math.max(0, pathToStart.length() - commonLength)));

        for (int i = commonLength; i < pathToDestination.length(); i++) {
            result.append(pathToDestination.charAt(i));
        }

        return result.toString();
    }

    private boolean findPath(TreeNode root, int value, StringBuilder stringBuilder) {
        if (root == null) {
            return false;
        }

        if (root.val == value) {
            return true;
        }

        stringBuilder.append("L");
        if (findPath(root.left, value, stringBuilder)) {
            return true;
        }
        stringBuilder.setLength(stringBuilder.length() - 1);

        stringBuilder.append("R");
        if (findPath(root.right, value, stringBuilder)) {
            return true;
        }
        stringBuilder.setLength(stringBuilder.length() - 1);

        return false;
    }

}
