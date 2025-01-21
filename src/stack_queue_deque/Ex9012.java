package stack_queue_deque;

import java.io.*;
import java.util.Stack;

public class Ex9012 {
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
        Stack<Character> stack = new Stack<>();

        for (char c : ps.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}