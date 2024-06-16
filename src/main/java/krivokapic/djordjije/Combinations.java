package krivokapic.djordjije;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


// https://leetcode.com/problems/combinations/description/
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            combinations(n, i, k, new ArrayList<>(), combinations);
        }

        return combinations;
    }

    private void combinations(int n, int currentN, int k, List<Integer> currentCombination, List<List<Integer>> combinations) {
        currentCombination.add(currentN);

        if (currentCombination.size() == k) {
            combinations.add(List.copyOf(currentCombination));
            return;
        }

        for (int i = currentN + 1; i <= n; i++) {
            combinations(n, i, k, currentCombination, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

}
