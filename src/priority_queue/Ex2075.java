package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2075 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(n);

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                while (st.hasMoreTokens()) {
                    int num = Integer.parseInt(st.nextToken());

                    if (pq.size() < n) {
                        pq.offer(num);
                    } else if (num > pq.peek()) {
                        pq.poll();
                        pq.offer(num);
                    }
                }
            }

            System.out.println(pq.peek());
        } catch (IOException e) {
        }
    }
}