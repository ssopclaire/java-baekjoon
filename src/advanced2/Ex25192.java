package advanced2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ex25192 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            Set<String> users = new HashSet<>();

            int count = 0;

            for (int i = 0; i < n; i++) {
                String input = br.readLine();

                if (input.equals("ENTER")) {
                    users.clear();
                } else {
                    if (users.add(input)) {
                        count++;
                    }
                }
            }

            System.out.println(count);
        } catch (IOException e) {
        }
    }
}