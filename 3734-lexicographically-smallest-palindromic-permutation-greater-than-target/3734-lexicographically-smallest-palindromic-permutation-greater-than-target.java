class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // A palindrome can have at most one odd frequency
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // Number of each character available in the left half
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        int halfLen = n / 2;

        StringBuilder left = new StringBuilder();

        /*
         * Build the left half from left to right.
         * At every position, try the smallest possible character.
         */
        for (int pos = 0; pos < halfLen; pos++) {

            boolean found = false;

            for (int c = 0; c < 26; c++) {

                if (half[c] == 0) {
                    continue;
                }

                // Take this character
                half[c]--;
                left.append((char) ('a' + c));

                /*
                 * Check whether ANY completion from here can
                 * produce a palindrome > target.
                 */
                if (canMakeGreater(left, half, middle, n, target)) {
                    found = true;
                    break;
                }

                // Undo
                left.deleteCharAt(left.length() - 1);
                half[c]++;
            }

            if (!found) {
                return "";
            }
        }

        // We have constructed the smallest valid left half
        String leftPart = left.toString();

        String answer = buildPalindrome(leftPart, middle, n);

        // Strictly greater is required
        if (answer.compareTo(target) > 0) {
            return answer;
        }

        return "";
    }

    private boolean canMakeGreater(
            StringBuilder left,
            int[] half,
            int middle,
            int n,
            String target) {

        /*
         * To check whether a solution exists, make the
         * LARGEST possible remaining left half.
         *
         * If even this palindrome <= target,
         * then no completion can work.
         */

        int[] temp = half.clone();

        StringBuilder completeLeft = new StringBuilder(left);

        // Largest possible completion
        for (int c = 25; c >= 0; c--) {
            while (temp[c] > 0) {
                completeLeft.append((char) ('a' + c));
                temp[c]--;
            }
        }

        String candidate =
                buildPalindrome(completeLeft.toString(), middle, n);

        return candidate.compareTo(target) > 0;
    }

    private String buildPalindrome(
            String left,
            int middle,
            int n) {

        StringBuilder result = new StringBuilder();

        // Left half
        result.append(left);

        // Middle character for odd length
        if ((n & 1) == 1) {
            result.append((char) ('a' + middle));
        }

        // Right half
        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}