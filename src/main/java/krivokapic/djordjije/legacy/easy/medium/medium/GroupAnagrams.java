package krivokapic.djordjije.legacy.easy.medium.medium;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// https://leetcode.com/problems/group-anagrams/description/
// Time Complexity: O(n)
// Space Complexity: O(n)
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsGrouped = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            int[] map = new int[26];

            for (int j = 0; j < strs[i].length(); j++) {
                map[strs[i].charAt(j) - 'a'] += 1;
            }

            StringBuilder keyBuilder = new StringBuilder();
            for (int j : map) {
                keyBuilder.append(j).append('#');
            }
            String key = keyBuilder.toString();

            if (anagramsGrouped.containsKey(key)) {
                anagramsGrouped.get(key).add(strs[i]);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(strs[i]);

                anagramsGrouped.put(key, anagrams);
            }
        }

        return anagramsGrouped.values().stream().toList();
    }

}
