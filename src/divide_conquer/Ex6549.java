package divide_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ex6549 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int n = Integer.parseInt(st.nextToken());

                if (n == 0) break;

                int[] h = new int[n + 1];

                for (int i = 0; i < n; i++) {
                    h[i] = Integer.parseInt(st.nextToken());
                }

                Deque<Integer> stack = new ArrayDeque<>(n + 1);

                long max = 0;

                for (int i = 0; i <= n; i++) {
                    int cur = h[i];

                    while (!stack.isEmpty() && h[stack.peek()] > cur) {
                        int top = stack.pop();

                        int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                        long area = (long) h[top] * (i - left);

                        if (area > max) max = area;
                    }

                    stack.push(i);
                }

                sb.append(max).append('\n');
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}