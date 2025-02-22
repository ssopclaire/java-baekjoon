package loops;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex25304 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int x = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int total = 0;

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                total += a * b;
            }

            System.out.println(total == x ? "Yes" : "No");
        } catch (IOException e) {
        }
    }
}