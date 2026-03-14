package shortest_path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ex13549 {
    static final int MAX = 100000;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n >= k) {
                System.out.println(n - k);
                return;
            }

            int[] dist = new int[MAX + 1];
            Arrays.fill(dist, Integer.MAX_VALUE);

            Deque<Integer> deque = new ArrayDeque<>();

            dist[n] = 0;
            deque.addFirst(n);

            while (!deque.isEmpty()) {
                int now = deque.pollFirst();

                if (now == k) {
                    System.out.println(dist[now]);
                    return;
                }

                int next = now * 2;

                if (next <= MAX && dist[next] > dist[now]) {
                    dist[next] = dist[now];
                    deque.addFirst(next);
                }

                next = now - 1;

                if (next >= 0 && dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    deque.addLast(next);
                }

                next = now + 1;

                if (next <= MAX && dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    deque.addLast(next);
                }
            }
        } catch (IOException e) {
        }
    }
}