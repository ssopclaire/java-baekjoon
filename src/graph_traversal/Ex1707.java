package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Ex1707 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int k = Integer.parseInt(br.readLine());

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int v = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                List<Integer>[] g = new ArrayList[v + 1];

                for (int i = 1; i <= v; i++) {
                    g[i] = new ArrayList<>();
                }

                for (int i = 0; i < e; i++) {
                    st = new StringTokenizer(br.readLine());

                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    g[a].add(b);
                    g[b].add(a);
                }

                byte[] color = new byte[v + 1];

                ArrayDeque<Integer> q = new ArrayDeque<>();

                boolean ok = true;

                for (int s = 1; s <= v && ok; s++) {
                    if (color[s] != 0) {
                        continue;
                    }

                    color[s] = 1;
                    q.add(s);

                    while (!q.isEmpty() && ok) {
                        int u = q.poll();

                        byte cu = color[u];

                        for (int next : g[u]) {
                            if (color[next] == 0) {
                                color[next] = (byte) -cu;
                                q.add(next);
                            } else if (color[next] == cu) {
                                ok = false;
                                break;
                            }
                        }
                    }
                }

                sb.append(ok ? "YES" : "NO").append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}