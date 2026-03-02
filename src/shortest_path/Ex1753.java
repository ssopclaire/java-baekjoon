package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1753 {
    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int start = Integer.parseInt(br.readLine());

            ArrayList<Edge>[] g = new ArrayList[v + 1];

            for (int i = 1; i <= v; i++) {
                g[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                g[from].add(new Edge(to, w));
            }

            int[] dist = new int[v + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

            dist[start] = 0;
            pq.add(new int[]{start, 0});

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();

                int now = cur[0];
                int d = cur[1];

                if (d > dist[now]) {
                    continue;
                }

                for (Edge nx : g[now]) {
                    int nd = d + nx.w;

                    if (nd < dist[nx.to]) {
                        dist[nx.to] = nd;
                        pq.add(new int[]{nx.to, nd});
                    }
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= v; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append("INF\n");
                } else {
                    sb.append(dist[i]).append('\n');
                }
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}