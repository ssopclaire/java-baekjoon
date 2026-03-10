package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11404 {
    private static int INF = 1_000_000_000;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            int[][] d = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                Arrays.fill(d[i], INF);
                d[i][i] = 0;
            }

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                d[a][b] = Math.min(d[a][b], c);
            }

            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    if (d[i][k] == INF) continue;

                    for (int j = 1; j <= n; j++) {
                        if (d[k][j] == INF) continue;

                        d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (j > 1) sb.append(' ');

                    sb.append(d[i][j] == INF ? 0 : d[i][j]);
                }

                sb.append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}