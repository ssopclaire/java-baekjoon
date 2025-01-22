package stack_queue_deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Ex18258 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            Deque<Integer> result = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                String command = br.readLine();

                if (command.startsWith("push")) {
                    int x = Integer.parseInt(command.split(" ")[1]);
                    result.addLast(x);
                } else if (command.equals("pop")) {
                    if (result.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(result.pollFirst()).append("\n");
                    }
                } else if (command.equals("size")) {
                    sb.append(result.size()).append("\n");
                } else if (command.equals("empty")) {
                    sb.append(result.isEmpty() ? "1\n" : "0\n");
                } else if (command.equals("front")) {
                    if (result.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(result.peekFirst()).append("\n");
                    }
                } else if (command.equals("back")) {
                    if (result.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(result.peekLast()).append("\n");
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