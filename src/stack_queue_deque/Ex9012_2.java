package stack_queue_deque;

import java.io.*;

public class Ex9012_2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int t = Integer.parseInt(br.readLine());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < t; i++) {
                String ps = br.readLine();
                if (isValidParenthesis(ps)) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }

            bw.write(sb.toString());
            bw.flush();

            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }

    private static boolean isValidParenthesis(String ps) {
        int count = 0;

        for (int i = 0; i < ps.length(); i++) {
            char c = ps.charAt(i);
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count < 0) {
                    return false;
                }
            }
        }

        return count == 0;
    }
}