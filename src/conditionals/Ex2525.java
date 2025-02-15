package conditionals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ex2525 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(br.readLine());

            int totalMin = a * 60 + b + c;
            int hour = (totalMin / 60) % 24;
            int min = totalMin % 60;

            System.out.println(hour + " " + min);
        } catch (IOException e) {
        }
    }
}