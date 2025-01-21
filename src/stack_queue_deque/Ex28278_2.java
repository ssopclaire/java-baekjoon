package stack_queue_deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex28278_2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            Deque<Integer> stack = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String command = br.readLine();

                if (command.startsWith("1")) {
                    int x = Integer.parseInt(command.split(" ")[1]);
                    stack.push(x);
                } else if (command.equals("2")) {
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.pop()).append("\n");
                    }
                } else if (command.equals("3")) {
                    sb.append(stack.size()).append("\n");
                } else if (command.equals("4")) {
                    sb.append(stack.isEmpty() ? "1\n" : "0\n");
                } else if (command.equals("5")) {
                    if (stack.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(stack.peek()).append("\n");
                    }
                }
            }

            bw.write(sb.toString());
            bw.flush();

            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}