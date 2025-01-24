package stack_queue_deque;

import java.io.*;
import java.util.Stack;

public class Ex10773 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int k = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < k; i++) {
                int number = Integer.parseInt(br.readLine());

                if (number == 0) {
                    stack.pop();
                } else {
                    stack.push(number);
                }
            }

            int sum = 0;

            while (!stack.isEmpty()) {
                sum += stack.pop();
            }

            bw.write(String.valueOf(sum));
            bw.flush();

            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}