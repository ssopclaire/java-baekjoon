package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex2252 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] indegree = new int[n + 1];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                indegree[b]++;
            }

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }

            StringBuilder sb = new StringBuilder();

            while (!queue.isEmpty()) {
                int now = queue.poll();

                sb.append(now).append(" ");

                for (int next : graph[now]) {
                    indegree[next]--;

                    if (indegree[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}