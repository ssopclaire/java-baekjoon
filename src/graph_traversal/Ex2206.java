package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2206 {
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            byte[][] map = new byte[n][m];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();

                for (int j = 0; j < m; j++) {
                    map[i][j] = (byte) (line.charAt(j) - '0');
                }
            }

            int[][] dist0 = new int[n][m];
            int[][] dist1 = new int[n][m];

            for (int i = 0; i < n; i++) {
                Arrays.fill(dist0[i], -1);
                Arrays.fill(dist1[i], -1);
            }

            ArrayDeque<Integer> q = new ArrayDeque<>();

            if (map[0][0] == 0) {
                dist0[0][0] = 1;
                q.add(0);
            } else {
                dist1[0][0] = 1;
                q.add(1);
            }

            while (!q.isEmpty()) {
                int code = q.poll();

                int used = code & 1;
                int pos = code >> 1;

                int r = pos / m;
                int c = pos % m;

                int curDist = (used == 0) ? dist0[r][c] : dist1[r][c];

                if (r == n - 1 && c == m - 1) {
                    System.out.println(curDist);
                    return;
                }

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                        continue;
                    }

                    if (map[nr][nc] == 0) {
                        if (used == 0) {
                            if (dist0[nr][nc] != -1) {
                                continue;
                            }

                            dist0[nr][nc] = curDist + 1;
                            q.add((((nr * m + nc) << 1) | 0));
                        } else {
                            if (dist1[nr][nc] != -1) {
                                continue;
                            }

                            dist1[nr][nc] = curDist + 1;
                            q.add((((nr * m + nc) << 1) | 1));
                        }
                    } else {
                        if (used == 0 && dist1[nr][nc] == -1) {
                            dist1[nr][nc] = curDist + 1;
                            q.add((((nr * m + nc) << 1) | 1));
                        }
                    }
                }
            }

            System.out.println(-1);
        } catch (IOException e) {
        }
    }
}