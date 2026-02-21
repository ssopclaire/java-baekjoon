package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.BitSet;
import java.util.Queue;
import java.util.StringTokenizer;

public class Ex3665 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            while (t-- > 0) {
                int n = Integer.parseInt(br.readLine());

                int[] last = new int[n];

                StringTokenizer st = new StringTokenizer(br.readLine());

                for (int i = 0; i < n; i++) {
                    last[i] = Integer.parseInt(st.nextToken());
                }

                BitSet[] graph = new BitSet[n + 1];

                for (int i = 1; i <= n; i++) {
                    graph[i] = new BitSet(n + 1);
                }

                int[] indegree = new int[n + 1];

                for (int i = 0; i < n; i++) {
                    int a = last[i];

                    for (int j = i + 1; j < n; j++) {
                        int b = last[j];

                        graph[a].set(b);
                        indegree[b]++;
                    }
                }

                int m = Integer.parseInt(br.readLine());

                for (int i = 0; i < m; i++) {
                    st = new StringTokenizer(br.readLine());

                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    if (graph[a].get(b)) {
                        graph[a].clear(b);
                        graph[b].set(a);

                        indegree[b]--;
                        indegree[a]++;
                    } else {
                        graph[b].clear(a);
                        graph[a].set(b);

                        indegree[a]--;
                        indegree[b]++;
                    }
                }

                Queue<Integer> queue = new ArrayDeque<>();

                for (int i = 1; i <= n; i++) {
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }

                int[] result = new int[n];

                boolean ambiguous = false;
                boolean impossible = false;

                for (int i = 0; i < n; i++) {
                    if (queue.isEmpty()) {
                        impossible = true;
                        break;
                    }

                    if (queue.size() > 1) {
                        ambiguous = true;
                    }

                    int now = queue.poll();
                    result[i] = now;

                    for (int next = graph[now].nextSetBit(1);
                         next != -1;
                         next = graph[now].nextSetBit(next + 1)) {

                        indegree[next]--;

                        if (indegree[next] == 0) {
                            queue.add(next);
                        }
                    }

                    graph[now].clear();
                }

                if (impossible) {
                    sb.append("IMPOSSIBLE\n");
                } else if (ambiguous) {
                    sb.append("?\n");
                } else {
                    for (int i = 0; i < n; i++) {
                        if (i > 0) {
                            sb.append(' ');
                        }

                        sb.append(result[i]);
                    }

                    sb.append('\n');
                }
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}