class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int[][] snapshots = new int[n][];
        int m = n;
        for (int i = 0; i < n; i++) {
            snapshots[i] = cnt.clone();
            int idx = target.charAt(i) - 'a';
            if (cnt[idx] > 0) {
                cnt[idx]--;
            } else {
                m = i + 1;
                break;
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            int[] snap = snapshots[i];
            int tIdx = target.charAt(i) - 'a';
            int chosen = -1;
            for (int c = tIdx + 1; c < 26; c++) {
                if (snap[c] > 0) {
                    chosen = c;
                    break;
                }
            }
            if (chosen != -1) {
                snap[chosen]--;
                StringBuilder suffix = new StringBuilder();
                for (int c = 0; c < 26; c++) {
                    for (int k = 0; k < snap[c]; k++) {
                        suffix.append((char) ('a' + c));
                    }
                }
                return target.substring(0, i) + (char) ('a' + chosen) + suffix;
            }
        }

        return "";
    }
}