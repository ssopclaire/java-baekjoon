package factors_primes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex5086 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringBuilder sb = new StringBuilder();

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (a == 0 && b == 0) {
                    break;
                }

                if (b % a == 0) {
                    sb.append("factor\n");
                } else if (a % b == 0) {
                    sb.append("multiple\n");
                } else {
                    sb.append("neither\n");
                }
            }

            System.out.println(sb);
        } catch (IOException e) {
        }
    }
}