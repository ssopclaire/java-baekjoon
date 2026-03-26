package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex9370 {
    static final long INF = Long.MAX_VALUE / 4;
    static ArrayList<Edge>[] graph;

    static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static class Node implements Comparable<Node> {
        int num;
        long dist;

        Node(int num, long dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.dist, o.dist);
        }
    }

    static long[] dijkstra(int start, int n) {
        long[] dist = new long[n + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (dist[now.num] < now.dist) {
                continue;
            }

            for (Edge next : graph[now.num]) {
                long nextDist = now.dist + next.cost;

                if (dist[next.to] > nextDist) {
                    dist[next.to] = nextDist;
                    pq.offer(new Node(next.to, nextDist));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int tc = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            while (tc-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                st = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());

                graph = new ArrayList[n + 1];

                for (int i = 1; i <= n; i++) {
                    graph[i] = new ArrayList<>();
                }

                int ghCost = 0;

                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());

                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int d = Integer.parseInt(st.nextToken());

                    graph[a].add(new Edge(b, d));
                    graph[b].add(new Edge(a, d));

                    if ((a == g && b == h) || (a == h && b == g)) {
                        ghCost = d;
                    }
                }

                int[] candidates = new int[t];

                for (int i = 0; i < t; i++) {
                    candidates[i] = Integer.parseInt(br.readLine());
                }

                Arrays.sort(candidates);

                long[] distS = dijkstra(s, n);
                long[] distG = dijkstra(g, n);
                long[] distH = dijkstra(h, n);

                for (int x : candidates) {
                    long path1 = distS[g] + ghCost + distH[x];
                    long path2 = distS[h] + ghCost + distG[x];

                    if (distS[x] == path1 || distS[x] == path2) {
                        sb.append(x).append(' ');
                    }
                }

                sb.append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}