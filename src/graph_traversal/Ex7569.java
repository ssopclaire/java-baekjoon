package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex7569 {
    static int m, n, h;
    static int[][][] box;

    static final int[] DX = {1, -1, 0, 0, 0, 0};
    static final int[] DY = {0, 0, 1, -1, 0, 0};
    static final int[] DZ = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            box = new int[h][n][m];

            ArrayDeque<Integer> q = new ArrayDeque<>();
            final int area = n * m;

            int unripe = 0;
            int max = 1;

            for (int z = 0; z < h; z++) {
                for (int x = 0; x < n; x++) {
                    st = new StringTokenizer(br.readLine());

                    for (int y = 0; y < m; y++) {
                        int v = Integer.parseInt(st.nextToken());

                        box[z][x][y] = v;

                        if (v == 1) q.add(z * area + x * m + y);
                        else if (v == 0) unripe++;
                    }
                }
            }

            if (unripe == 0) {
                System.out.println(0);
                return;
            }

            while (!q.isEmpty()) {
                int pos = q.poll();

                int z = pos / area;
                int rem = pos - z * area;
                int x = rem / m;
                int y = rem - x * m;

                int curDay = box[z][x][y];

                for (int dir = 0; dir < 6; dir++) {
                    int nz = z + DZ[dir];
                    int nx = x + DX[dir];
                    int ny = y + DY[dir];

                    if (nz < 0 || nz >= h || nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                    if (box[nz][nx][ny] != 0) continue;

                    int nextDay = curDay + 1;

                    box[nz][nx][ny] = nextDay;
                    q.add(nz * area + nx * m + ny);

                    unripe--;

                    if (nextDay > max) max = nextDay;

                    if (unripe == 0) {
                        System.out.println(max - 1);
                        return;
                    }
                }
            }

            System.out.println(-1);
        } catch (IOException e) {
        }
    }
}