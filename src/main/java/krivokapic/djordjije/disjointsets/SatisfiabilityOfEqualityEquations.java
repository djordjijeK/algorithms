package krivokapic.djordjije.disjointsets;

import java.util.HashMap;
import java.util.Map;


public class SatisfiabilityOfEqualityEquations {
    // https://leetcode.com/problems/satisfiability-of-equality-equations/description/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind();

        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            char sign = equation.charAt(1);

            if (sign == '=') {
                unionFind.connect(x, y);
            }
        }

        for (String equation : equations) {
            char x = equation.charAt(0);
            char y = equation.charAt(3);
            char sign = equation.charAt(1);

            if (sign == '!' && (x == y || unionFind.areConnected(x, y))) {
                return false;
            }
        }

        return true;
    }


    private static class UnionFind {
        private final Map<Character, Character> itemToParent;
        private final Map<Character, Integer> rootToSize;


        public UnionFind() {
            this.itemToParent = new HashMap<>();
            this.rootToSize = new HashMap<>();
        }


        public void connect(Character x, Character y) {
            Character parentX = find(x);
            Character parentY = find(y);

            if (parentX == null) {
                itemToParent.put(x, x);
                rootToSize.put(x, 1);
                parentX = x;
            }

            if (parentY == null) {
                itemToParent.put(y, y);
                rootToSize.put(y, 1);
                parentY = y;
            }

            if (parentX == parentY) {
                return;
            }

            int sizeX = rootToSize.get(parentX);
            int sizeY = rootToSize.get(parentY);

            if (sizeX >= sizeY) {
                itemToParent.put(parentY, parentX);
                rootToSize.put(parentX, sizeX + sizeY);
            } else {
                itemToParent.put(parentX, parentY);
                rootToSize.put(parentY, sizeX + sizeY);
            }
        }


        public boolean areConnected(char x, char y) {
            Character parentX = find(x);
            Character parentY = find(y);

            if (parentX == null || parentY == null) {
                return false;
            }

            return parentX.equals(parentY);
        }


        private Character find(Character search) {
            if (!itemToParent.containsKey(search)) {
                return null;
            }

            Character root = search;
            while (!root.equals(itemToParent.get(root))) {
                root = itemToParent.get(root);
            }

            while (!search.equals(root)) {
                Character temp = search;
                search = itemToParent.get(search);

                itemToParent.put(temp, root);
            }

            return root;
        }
    }
}
