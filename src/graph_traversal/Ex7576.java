package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex7576 {
    static int m, n;
    static int[][] box;

    static final int[] DX = {1, -1, 0, 0};
    static final int[] DY = {0, 0, 1, -1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            box = new int[n][m];

            ArrayDeque<Integer> q = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < m; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());

                    if (box[i][j] == 1) {
                        q.add(i * m + j);
                    }
                }
            }

            while (!q.isEmpty()) {
                int pos = q.poll();
                int x = pos / m;
                int y = pos % m;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + DX[dir];
                    int ny = y + DY[dir];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }

                    if (box[nx][ny] != 0) {
                        continue;
                    }

                    box[nx][ny] = box[x][y] + 1;

                    q.add(nx * m + ny);
                }
            }

            int max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (box[i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }

                    if (box[i][j] > max) {
                        max = box[i][j];
                    }
                }
            }

            System.out.println(max - 1);
        } catch (IOException e) {
        }
    }
}