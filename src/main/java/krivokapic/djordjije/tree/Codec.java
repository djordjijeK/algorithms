package krivokapic.djordjije.tree;


// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
public class Codec {


    public String serialize(TreeNode root) {
        StringBuilder serializedTree = new StringBuilder();
        dfsSerialize(root, serializedTree);
        serializedTree.setLength(serializedTree.length() - 1);

        return serializedTree.toString();
    }


    public TreeNode deserialize(String data) {
        String[] values = data.split(",");

        int[] index = {0};
        return dfsDeserialize(values, index);
    }


    private void dfsSerialize(TreeNode current, StringBuilder result) {
        if (current == null) {
            result.append("null").append(",");
            return;
        }

        result.append(current.val).append(",");
        dfsSerialize(current.left, result);
        dfsSerialize(current.right, result);
    }


    private TreeNode dfsDeserialize(String[] values, int[] index) {
        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index[0]]));

        index[0]++;

        root.left = dfsDeserialize(values, index);
        root.right = dfsDeserialize(values, index);

        return root;
    }
}
