package cumulative_sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex10986 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] modCount = new long[m];

            long sum = 0;
            long result = 0;

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                sum = (sum + Integer.parseInt(st.nextToken())) % m;
                if (sum < 0) sum += m;

                if (sum == 0) result++;

                result += modCount[(int) sum];
                modCount[(int) sum]++;
            }

            System.out.println(result);
        } catch (IOException e) {
        }
    }
}