package conditionals;

import java.io.*;

public class Ex2884 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] str = br.readLine().split(" ");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            if (m < 45) {
                h--;
                m = 60 - (45 - m);
                if (h < 0) {
                    h = 23;
                }
            } else {
                m -= 45;
            }

            bw.write(h + " " + m + "\n");
            bw.flush();

            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}