package krivokapic.djordjije;


// https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] targetMask = new int[26];
        int[] currentMask = new int[26];
        for (char character : s1.toCharArray()) {
            targetMask[character - 'a'] += 1;
        }

        for (int index = 0; index < s1.length(); index++) {
            currentMask[s2.charAt(index) - 'a'] += 1;
        }

        int matches = 0;
        for (int index = 0; index < 26; index++) {
            matches += Math.min(targetMask[index], currentMask[index]);
        }

        for (int index = s1.length(); index < s2.length(); index++) {
            if (matches == s1.length()) {
                return true;
            }

            char outsideWindowCharacter = s2.charAt(index - s1.length());
            int before = Math.min(targetMask[outsideWindowCharacter - 'a'], currentMask[outsideWindowCharacter - 'a']);
            currentMask[outsideWindowCharacter - 'a'] -= 1;
            int now = Math.min(targetMask[outsideWindowCharacter - 'a'], currentMask[outsideWindowCharacter - 'a']);
            matches += now - before;

            char inWindowCharacter = s2.charAt(index);
            before = Math.min(targetMask[inWindowCharacter - 'a'], currentMask[inWindowCharacter - 'a']);
            currentMask[inWindowCharacter - 'a'] += 1;
            now = Math.min(targetMask[inWindowCharacter - 'a'], currentMask[inWindowCharacter - 'a']);
            matches +=  now - before;
        }

        return matches == s1.length();
    }

}
