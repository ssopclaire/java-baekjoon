package advanced2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Ex26069 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Set<String> dancers = new HashSet<>();

            dancers.add("ChongChong");

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                if (dancers.contains(a) || dancers.contains(b)) {
                    dancers.add(a);
                    dancers.add(b);
                }
            }

            System.out.println(dancers.size());
        } catch (IOException e) {
        }
    }
}