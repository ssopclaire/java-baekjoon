package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Ex1012 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            StringBuilder sb = new StringBuilder();

            ArrayDeque<Integer> q = new ArrayDeque<>();

            while (t-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int n = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                boolean[][] cab = new boolean[m][n];

                int[] xs = new int[k];
                int[] ys = new int[k];

                for (int i = 0; i < k; i++) {
                    st = new StringTokenizer(br.readLine());

                    int x = Integer.parseInt(st.nextToken());
                    int y = Integer.parseInt(st.nextToken());

                    cab[x][y] = true;

                    xs[i] = x;
                    ys[i] = y;
                }

                int worms = 0;

                q.clear();

                for (int i = 0; i < k; i++) {
                    int sx = xs[i];
                    int sy = ys[i];

                    if (!cab[sx][sy]) continue;

                    worms++;

                    cab[sx][sy] = false;
                    q.add(sx * n + sy);

                    while (!q.isEmpty()) {
                        int pos = q.poll();

                        int x = pos / n;
                        int y = pos % n;

                        for (int d = 0; d < 4; d++) {
                            int nx = x + dx[d];
                            int ny = y + dy[d];

                            if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                            if (!cab[nx][ny]) continue;

                            cab[nx][ny] = false;
                            q.add(nx * n + ny);
                        }
                    }
                }

                sb.append(worms).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}