package advanced1;

import java.io.*;

public class Ex2444 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 2 * n - 1; i++) {
            int stars = i <= n ? 2 * i - 1 : 2 * (2 * n - i) - 1;
            int spaces = (2 * n - 1 - stars) / 2;

            sb.append(" ".repeat(spaces)).append("*".repeat(stars)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}