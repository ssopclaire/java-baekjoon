package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Ex11286 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (a, b) -> Math.abs(a) == Math.abs(b)
                            ? Integer.compare(a, b)
                            : Integer.compare(Math.abs(a), Math.abs(b))
            );

            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(br.readLine());

                if (x == 0) {
                    sb.append(pq.isEmpty() ? 0 : pq.poll()).append('\n');
                } else {
                    pq.offer(x);
                }
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}