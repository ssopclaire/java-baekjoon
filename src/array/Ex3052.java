package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Ex3052 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            Set<Integer> remainderSet = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                int num = Integer.parseInt(br.readLine());
                remainderSet.add(num % 42);
            }

            System.out.println(remainderSet.size());
        } catch (IOException e) {
        }
    }
}