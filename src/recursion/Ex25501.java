package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex25501 {
    static int count;

    static int recursion(String s, int start, int end) {
        count++;
        if (start >= end) return 1;
        else if (s.charAt(start) != s.charAt(end)) return 0;
        else return recursion(s, start + 1, end - 1);
    }

    static int isPalindrome(String s) {
        count = 0;
        return recursion(s, 0, s.length() - 1);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                String s = br.readLine();
                int result = isPalindrome(s);
                sb.append(result).append(" ").append(count).append("\n");
            }

            System.out.print(sb);
        } catch (IOException e) {
        }
    }
}