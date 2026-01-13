package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Ex2606 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int m = Integer.parseInt(br.readLine());

            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            boolean[] visited = new boolean[n + 1];
            ArrayDeque<Integer> queue = new ArrayDeque<>();

            visited[1] = true;

            queue.add(1);

            int infected = 0;

            while (!queue.isEmpty()) {
                int cur = queue.poll();

                for (int next : graph[cur]) {
                    if (visited[next]) continue;

                    visited[next] = true;
                    infected++;

                    queue.add(next);
                }
            }

            System.out.print(infected);
        } catch (IOException e) {
        }
    }
}