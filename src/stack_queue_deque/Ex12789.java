package stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Ex12789 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            Stack<Integer> stack = new Stack<>();
            int current = 1;

            while (!queue.isEmpty() || !stack.isEmpty()) {
                if (!queue.isEmpty() && queue.peek() == current) {
                    queue.poll();
                    current++;
                } else if (!stack.isEmpty() && stack.peek() == current) {
                    stack.pop();
                    current++;
                } else if (!queue.isEmpty()) {
                    stack.push(queue.poll());
                } else {
                    break;
                }
            }

            if (queue.isEmpty() && stack.isEmpty()) {
                System.out.println("Nice");
            } else {
                System.out.println("Sad");
            }
        } catch (IOException e) {
        }
    }
}