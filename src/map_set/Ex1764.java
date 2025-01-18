package map_set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex1764 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();

        Set<String> unheard = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unheard.add(scanner.nextLine());
        }

        List<String> unheardUnseen = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String name = scanner.nextLine();
            if (unheard.contains(name)) {
                unheardUnseen.add(name);
            }
        }

        Collections.sort(unheardUnseen);

        System.out.println(unheardUnseen.size());
        for (String name : unheardUnseen) {
            System.out.println(name);
        }
    }
}