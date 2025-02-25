package loops;

import java.io.*;
import java.util.StringTokenizer;

public class Ex11022 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int t = Integer.parseInt(br.readLine());

            for (int i = 1; i <= t; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = a + b;

                bw.write(String.format("Case #%d: %d + %d = %d\n", i, a, b, c));
            }

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}