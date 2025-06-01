package factors_primes2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex13241 {
    private static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            long gcdValue = gcd(a, b);
            long lcm = (a / gcdValue) * b;

            System.out.println(lcm);
        } catch (IOException e) {
        }
    }
}