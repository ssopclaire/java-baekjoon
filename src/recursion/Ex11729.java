package recursion;

import java.io.*;

public class Ex11729 {
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int n, int start, int end) {
        if (n == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        int mid = 6 - start - end;

        hanoi(n - 1, start, mid);

        sb.append(start).append(" ").append(end).append("\n");

        hanoi(n - 1, mid, end);
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());

            sb.append((1 << n) - 1).append("\n");

            hanoi(n, 1, 3);

            bw.write(sb.toString());

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}