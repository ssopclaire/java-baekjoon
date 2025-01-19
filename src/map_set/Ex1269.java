package map_set;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex1269 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Integer> setA = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setA.add(scanner.nextInt());
        }

        Set<Integer> setB = new HashSet<>();
        for (int i = 0; i < m; i++) {
            setB.add(scanner.nextInt());
        }

        int symmetricDifferenceSize = 0;

        for (int num : setA) {
            if (!setB.contains(num)) {
                symmetricDifferenceSize++;
            }
        }

        for (int num : setB) {
            if (!setA.contains(num)) {
                symmetricDifferenceSize++;
            }
        }

        System.out.println(symmetricDifferenceSize);
    }
}