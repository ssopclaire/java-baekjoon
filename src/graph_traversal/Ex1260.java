package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex1260 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i = 1; i <= n; i++) {
                Collections.sort(graph[i]);
            }

            StringBuilder out = new StringBuilder();

            boolean[] visited = new boolean[n + 1];

            dfsIter(v, graph, visited, out);

            out.setLength(out.length() - 1);
            out.append('\n');

            Arrays.fill(visited, false);

            bfs(v, graph, visited, out);

            out.setLength(out.length() - 1);

            System.out.print(out);
        } catch (IOException e) {
        }
    }

    static void dfsIter(int start, ArrayList<Integer>[] graph, boolean[] visited, StringBuilder sb) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);

        while (!stack.isEmpty()) {
            int cur = stack.pop();

            if (visited[cur]) {
                continue;
            }

            visited[cur] = true;
            sb.append(cur).append(' ');

            ArrayList<Integer> adj = graph[cur];

            for (int i = adj.size() - 1; i >= 0; i--) {
                int nxt = adj.get(i);

                if (!visited[nxt]) {
                    stack.push(nxt);
                }
            }
        }
    }

    static void bfs(int start, ArrayList<Integer>[] graph, boolean[] visited, StringBuilder sb) {
        Queue<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.add(start);

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(' ');

            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    q.add(nxt);
                }
            }
        }
    }
}