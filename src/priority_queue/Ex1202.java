package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Ex1202 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            Jewel[] jewels = new Jewel[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int m = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                jewels[i] = new Jewel(m, v);
            }

            int[] c = new int[k];

            for (int i = 0; i < k; i++) {
                c[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(jewels, Comparator.comparingInt(j -> j.m));
            Arrays.sort(c);

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            long sum = 0L;
            int j = 0;

            for (int cap : c) {
                while (j < n && jewels[j].m <= cap) {
                    pq.add(jewels[j++].v);
                }

                if (!pq.isEmpty()) {
                    sum += pq.poll();
                }
            }

            System.out.println(sum);
        } catch (IOException e) {
        }
    }

    static class Jewel {
        int m, v;

        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
    }
}