package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11657 {
    static final long INF = Long.MAX_VALUE;

    static class Edge {
        int from;
        int to;
        int cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Edge[] edges = new Edge[m];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(a, b, c);
            }

            long[] dist = new long[n + 1];
            Arrays.fill(dist, INF);
            dist[1] = 0;

            for (int i = 1; i < n; i++) {
                boolean updated = false;

                for (Edge edge : edges) {
                    if (dist[edge.from] == INF) {
                        continue;
                    }

                    if (dist[edge.to] > dist[edge.from] + edge.cost) {
                        dist[edge.to] = dist[edge.from] + edge.cost;
                        updated = true;
                    }
                }

                if (!updated) {
                    break;
                }
            }

            for (Edge edge : edges) {
                if (dist[edge.from] == INF) {
                    continue;
                }

                if (dist[edge.to] > dist[edge.from] + edge.cost) {
                    System.out.println(-1);
                    return;
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 2; i <= n; i++) {
                if (dist[i] == INF) {
                    sb.append(-1).append('\n');
                    continue;
                }

                sb.append(dist[i]).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}