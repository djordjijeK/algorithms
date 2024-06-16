package krivokapic.djordjije;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;


// https://leetcode.com/problems/minimum-genetic-mutation/description
public class MinimumGeneticMutation {

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<Character> chars = new HashSet<>(Arrays.asList('A', 'C', 'G', 'T'));
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<Tuple> queue = new ArrayDeque<>();
        queue.add(new Tuple(startGene, 0));
        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        while (!queue.isEmpty()) {
            Tuple current = queue.poll();
            String currentGene = current.gene;
            int currentMutations = current.mutations;

            for (int index = 0; index < currentGene.length(); index++) {
                for (char c : chars) {
                    if (c == currentGene.charAt(index)) {
                        continue;
                    }

                    char[] geneArray = currentGene.toCharArray();
                    geneArray[index] = c;
                    String mutation = new String(geneArray);

                    if (mutation.equals(endGene)) {
                        return currentMutations + 1;
                    }

                    if (bankSet.contains(mutation) && !visited.contains(mutation)) {
                        queue.offer(new Tuple(mutation, currentMutations + 1));
                        visited.add(mutation);
                    }
                }
            }
        }

        return -1;
    }

    record Tuple(String gene, int mutations) {};
}
