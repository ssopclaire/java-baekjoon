package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1956 {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int[][] dist = new int[v + 1][v + 1];

            for (int i = 1; i <= v; i++) {
                Arrays.fill(dist[i], INF);
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                if (dist[a][b] > c) {
                    dist[a][b] = c;
                }
            }

            for (int k = 1; k <= v; k++) {
                for (int i = 1; i <= v; i++) {
                    if (dist[i][k] == INF) {
                        continue;
                    }

                    for (int j = 1; j <= v; j++) {
                        if (dist[k][j] == INF) {
                            continue;
                        }

                        if (dist[i][j] > dist[i][k] + dist[k][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }

            int answer = INF;

            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (dist[i][j] != INF && dist[j][i] != INF) {
                        answer = Math.min(answer, dist[i][j] + dist[j][i]);
                    }
                }
            }

            System.out.println(answer == INF ? -1 : answer);
        } catch (IOException e) {
        }
    }
}