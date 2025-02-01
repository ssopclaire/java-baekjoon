package stack_queue_deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Ex24511_2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st;

            int n = Integer.parseInt(br.readLine());
            int[] listQueuestack = new int[n];
            int[] currentlist = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                listQueuestack[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                currentlist[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] insertList = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                insertList[i] = Integer.parseInt(st.nextToken());
            }

            Deque<Integer> queue = new ArrayDeque<>();

            for (int i = 0; i < n; i++) {
                if (listQueuestack[i] == 0) {
                    queue.addFirst(currentlist[i]);
                }
            }
            for (int i = 0; i < m; i++) {
                queue.add(insertList[i]);
                bw.write(queue.pollFirst() + " ");
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}