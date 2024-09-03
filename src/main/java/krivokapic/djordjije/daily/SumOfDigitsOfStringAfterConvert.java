package krivokapic.djordjije.daily;

public class SumOfDigitsOfStringAfterConvert {
    // https://leetcode.com/problems/sum-of-digits-of-string-after-convert/description/
    // Time Complexity: O(k * length)
    // Space Complexity: O(1)
    public int getLucky(String s, int k) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'a' + 1;

            result += num / 10 + num % 10;
        }

        while (k > 1) {
            int sum = 0;

            while (result > 0) {
                sum += result % 10;
                result /= 10;
            }

            result = sum;
            k--;
        }

        return result;
    }
}
