package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1504 {
    static class Edge {
        int to, w;

        Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }
    }

    static int n, e;
    static ArrayList<Edge>[] g;
    static final int INF = 200_000_000;

    static int[] dijkstra(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);

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

        return dist;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            g = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                g[a].add(new Edge(b, c));
                g[b].add(new Edge(a, c));
            }

            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            int[] d1 = dijkstra(1);
            int[] dv1 = dijkstra(v1);
            int[] dv2 = dijkstra(v2);

            long path1 = (long) d1[v1] + dv1[v2] + dv2[n];
            long path2 = (long) d1[v2] + dv2[v1] + dv1[n];

            long ans = Math.min(path1, path2);

            System.out.println(ans >= INF ? -1 : ans);
        } catch (IOException e) {
        }
    }
}