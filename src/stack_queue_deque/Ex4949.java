package stack_queue_deque;

import java.io.*;
import java.util.Stack;

public class Ex4949 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while (true) {
                String line = br.readLine();

                if (line.equals(".")) {
                    break;
                }

                if (isBalanced(line)) {
                    bw.write("yes\n");
                } else {
                    bw.write("no\n");
                }
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }

    private static boolean isBalanced(String line) {
        Stack<Character> stack = new Stack<>();

        for (char c : line.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}