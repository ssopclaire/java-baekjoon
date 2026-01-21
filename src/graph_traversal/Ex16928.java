package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex16928 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[] board = new int[101];

            for (int i = 0; i < n + m; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                board[from] = to;
            }

            int[] dist = new int[101];
            Arrays.fill(dist, -1);

            ArrayDeque<Integer> q = new ArrayDeque<>();

            q.add(1);
            dist[1] = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int d = 1; d <= 6; d++) {
                    int nx = cur + d;

                    if (nx > 100) continue;

                    if (board[nx] != 0) nx = board[nx];

                    if (dist[nx] != -1) continue;

                    dist[nx] = dist[cur] + 1;

                    if (nx == 100) {
                        System.out.println(dist[nx]);
                        return;
                    }

                    q.add(nx);
                }
            }
        } catch (IOException e) {
        }
    }
}