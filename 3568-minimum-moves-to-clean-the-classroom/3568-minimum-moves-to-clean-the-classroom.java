class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();

        int[][] id = new int[m][n];
        int sr = 0, sc = 0, cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);

                if (c == 'S') {
                    sr = i;
                    sc = j;
                } else if (c == 'L') {
                    id[i][j] = cnt++;
                }
            }
        }

        if (cnt == 0) return 0;

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << cnt];

        List<int[]> queue = new ArrayList<>();
        int startMask = (1 << cnt) - 1;

        queue.add(new int[]{sr, sc, energy, startMask});
        visited[sr][sc][energy][startMask] = true;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int moves = 0;

        while (!queue.isEmpty()) {
            List<int[]> next = new ArrayList<>();

            for (int[] state : queue) {
                int r = state[0];
                int c = state[1];
                int e = state[2];
                int mask = state[3];

                if (mask == 0) return moves;
                if (e == 0) continue;

                for (int k = 0; k < 4; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                        continue;

                    char ch = classroom[nr].charAt(nc);

                    if (ch == 'X') continue;

                    int newEnergy = e - 1;

                    if (ch == 'R') {
                        newEnergy = energy;
                    }

                    int newMask = mask;

                    if (ch == 'L') {
                        newMask &= ~(1 << id[nr][nc]);
                    }

                    if (!visited[nr][nc][newEnergy][newMask]) {
                        visited[nr][nc][newEnergy][newMask] = true;
                        next.add(new int[]{
                            nr, nc, newEnergy, newMask
                        });
                    }
                }
            }

            queue = next;
            moves++;
        }

        return -1;
    }
}