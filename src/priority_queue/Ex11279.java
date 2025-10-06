package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Ex11279 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            int n = Integer.parseInt(br.readLine());

            while (n-- > 0) {
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