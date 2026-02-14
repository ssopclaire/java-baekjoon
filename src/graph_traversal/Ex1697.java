package graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex1697 {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == k) {
                System.out.println(0);
                return;
            }

            int[] dist = new int[MAX + 1];
            Arrays.fill(dist, -1);

            ArrayDeque<Integer> q = new ArrayDeque<>();

            q.add(n);
            dist[n] = 0;

            while (!q.isEmpty()) {
                int cur = q.poll();
                int nextTime = dist[cur] + 1;

                int nx = cur - 1;

                if (nx >= 0 && dist[nx] == -1) {
                    dist[nx] = nextTime;

                    if (nx == k) {
                        System.out.println(nextTime);
                        return;
                    }

                    q.add(nx);
                }

                nx = cur + 1;

                if (nx <= MAX && dist[nx] == -1) {
                    dist[nx] = nextTime;

                    if (nx == k) {
                        System.out.println(nextTime);
                        return;
                    }

                    q.add(nx);
                }

                nx = cur * 2;

                if (nx <= MAX && dist[nx] == -1) {
                    dist[nx] = nextTime;

                    if (nx == k) {
                        System.out.println(nextTime);
                        return;
                    }

                    q.add(nx);
                }
            }
        } catch (IOException e) {
        }
    }
}