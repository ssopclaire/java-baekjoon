package advanced1;

import java.io.*;

public class Ex1316 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (isGroupWord(br.readLine())) {
                    count++;
                }
            }

            bw.write(count + "\n");

            bw.flush();
            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }

    public static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26];
        char prev = 0;

        for (char c : word.toCharArray()) {
            if (c != prev) {
                if (seen[c - 'a']) return false;
                seen[c - 'a'] = true;
            }
            prev = c;
        }

        return true;
    }
}