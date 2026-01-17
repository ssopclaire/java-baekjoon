package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Ex2667 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            boolean[][] home = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                char[] row = br.readLine().toCharArray();

                for (int j = 0; j < n; j++) {
                    home[i][j] = (row[j] == '1');
                }
            }

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            ArrayList<Integer> sizes = new ArrayList<>();
            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!home[i][j]) continue;

                    home[i][j] = false;
                    q.add(i * n + j);

                    int cnt = 0;

                    while (!q.isEmpty()) {
                        int pos = q.poll();
                        int x = pos / n;
                        int y = pos % n;

                        cnt++;

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                            if (!home[nx][ny]) continue;

                            home[nx][ny] = false;
                            q.add(nx * n + ny);
                        }
                    }

                    sizes.add(cnt);
                }
            }

            Collections.sort(sizes);

            StringBuilder sb = new StringBuilder();
            sb.append(sizes.size()).append('\n');

            for (int s : sizes) {
                sb.append(s).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}