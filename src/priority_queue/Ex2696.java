package priority_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Ex2696 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                int m = Integer.parseInt(br.readLine());

                int half = (m + 1) / 2;

                sb.append(half).append('\n');

                PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
                PriorityQueue<Integer> right = new PriorityQueue<>();

                int read = 0, lineCount = 0, printed = 0;

                while (read < m) {
                    StringTokenizer st = new StringTokenizer(br.readLine());

                    while (st.hasMoreTokens()) {
                        int num = Integer.parseInt(st.nextToken());

                        read++;

                        addNumber(left, right, num);

                        if ((read & 1) == 1) {
                            sb.append(left.peek());

                            printed++;
                            lineCount++;

                            if (lineCount == 10 || printed == half) {
                                sb.append('\n');

                                lineCount = 0;
                            } else {
                                sb.append(' ');
                            }
                        }
                    }
                }
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }

    private static void addNumber(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {
        if (left.size() == right.size()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        if (!right.isEmpty() && left.peek() > right.peek()) {
            int a = left.poll();
            int b = right.poll();

            left.offer(b);
            right.offer(a);
        }
    }
}