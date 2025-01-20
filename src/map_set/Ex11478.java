package map_set;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Ex11478 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String s = br.readLine();
            int n = s.length();

            Set<String> substrings = new HashSet<>();
            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = i; j < n; j++) {
                    sb.append(s.charAt(j));
                    substrings.add(sb.toString());
                }
            }

            bw.write(String.valueOf(substrings.size()));
            bw.newLine();
            bw.flush();

            bw.close();
            br.close();
        } catch (IOException e) {
        }
    }
}