package stack_queue_deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ex28279 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            Deque<Integer> deque = new ArrayDeque<>();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                switch (command) {
                    case "1":
                        deque.addFirst(Integer.parseInt(st.nextToken()));
                        break;
                    case "2":
                        deque.addLast(Integer.parseInt(st.nextToken()));
                        break;
                    case "3":
                        sb.append(!deque.isEmpty() ? deque.removeFirst() : -1).append("\n");
                        break;
                    case "4":
                        sb.append(!deque.isEmpty() ? deque.removeLast() : -1).append("\n");
                        break;
                    case "5":
                        sb.append(deque.size()).append("\n");
                        break;
                    case "6":
                        sb.append(deque.isEmpty() ? 1 : 0).append("\n");
                        break;
                    case "7":
                        sb.append(!deque.isEmpty() ? deque.getFirst() : -1).append("\n");
                        break;
                    case "8":
                        sb.append(!deque.isEmpty() ? deque.getLast() : -1).append("\n");
                        break;
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