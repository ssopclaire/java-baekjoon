package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Ex24479 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                graph[u].add(v);
                graph[v].add(u);
            }

            for (int i = 1; i <= n; i++) {
                Collections.sort(graph[i]);
            }

            int[] visitOrder = new int[n + 1];
            int order = 1;

            ArrayDeque<int[]> stack = new ArrayDeque<>();

            visitOrder[r] = order++;

            stack.push(new int[]{r, 0});

            while (!stack.isEmpty()) {
                int[] frame = stack.peek();

                int cur = frame[0];
                int idx = frame[1];

                if (idx >= graph[cur].size()) {
                    stack.pop();
                    continue;
                }

                int next = graph[cur].get(idx);

                frame[1] = idx + 1;

                if (visitOrder[next] == 0) {
                    visitOrder[next] = order++;
                    stack.push(new int[]{next, 0});
                }
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i <= n; i++) {
                sb.append(visitOrder[i]).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}