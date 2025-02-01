package stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Ex24511 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();
            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Deque<Integer>[] structures = new Deque[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                structures[i] = (arr[i] == 0) ? new LinkedList<>() : new ArrayDeque<>();
                structures[i].add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int x = Integer.parseInt(st.nextToken());

                for (int j = 0; j < n; j++) {
                    structures[j].add(x);

                    x = (arr[j] == 0) ? structures[j].pollFirst() : structures[j].pollLast();
                }

                sb.append(x).append(" ");
            }

            System.out.println(sb.toString().trim());
        } catch (IOException e) {
        }
    }
}