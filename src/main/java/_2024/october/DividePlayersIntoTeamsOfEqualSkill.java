package _2024.october;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class DividePlayersIntoTeamsOfEqualSkill {
    // https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public long dividePlayers(int[] skill) {
        int sum = Arrays.stream(skill).sum();
        if (sum % (skill.length / 2) != 0) {
            return -1;
        }

        int target = sum / (skill.length / 2);

        Map<Integer, Integer> map = new HashMap<>();
        for (int s : skill) {
            map.put(s, map.computeIfAbsent(s, i -> 0) + 1);
        }

        long total = 0;
        for (int sk : map.keySet()) {
            for (int i = 0; i < map.get(sk); i++) {
                if (!map.containsKey(target - sk) || map.get(target - sk) <= 0) {
                    return -1;
                }

                map.put(target - sk, map.get(target - sk) - 1);
                total += (long) sk * (target - sk);
            }
        }

        return total;
    }
}
