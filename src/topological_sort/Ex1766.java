package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex1766 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer>[] g = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<>();
            }

            int[] indeg = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                g[a].add(b);
                indeg[b]++;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for (int i = 1; i <= n; i++) {
                if (indeg[i] == 0) {
                    pq.offer(i);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!pq.isEmpty()) {
                int cur = pq.poll();

                sb.append(cur).append(' ');

                for (int nxt : g[cur]) {
                    if (--indeg[nxt] == 0) {
                        pq.offer(nxt);
                    }
                }
            }

            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}