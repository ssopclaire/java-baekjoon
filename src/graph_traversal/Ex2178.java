package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex2178 {
    static int n, m;
    static char[][] map;
    static int[][] dist;

    static final int[] DR = {-1, 1, 0, 0};
    static final int[] DC = {0, 0, -1, 1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            map = new char[n][m];
            dist = new int[n][m];

            for (int i = 0; i < n; i++) {
                String line = br.readLine();

                for (int j = 0; j < m; j++) {
                    map[i][j] = line.charAt(j);
                }
            }

            bfs();

            System.out.println(dist[n - 1][m - 1]);
        } catch (IOException e) {
        }
    }

    static void bfs() {
        ArrayDeque<int[]> q = new ArrayDeque<>();

        dist[0][0] = 1;
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            if (r == n - 1 && c == m - 1) return;

            for (int k = 0; k < 4; k++) {
                int nr = r + DR[k];
                int nc = c + DC[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (map[nr][nc] == '0') continue;
                if (dist[nr][nc] != 0) continue;

                dist[nr][nc] = dist[r][c] + 1;
                q.add(new int[]{nr, nc});
            }
        }
    }
}