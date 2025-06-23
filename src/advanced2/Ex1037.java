package advanced2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex1037 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());

                if (num < min) min = num;
                if (num > max) max = num;
            }

            System.out.println(min * max);
        } catch (IOException e) {
        }
    }
}