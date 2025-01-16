package map_set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex7785 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        Set<String> peopleInCompany = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String record = scanner.nextLine();
            String[] parts = record.split(" ");
            String name = parts[0];
            String status = parts[1];

            if (status.equals("enter")) {
                peopleInCompany.add(name);
            } else {
                peopleInCompany.remove(name);
            }
        }

        List<String> sortedPeople = new ArrayList<>(peopleInCompany);
        sortedPeople.sort(Collections.reverseOrder());

        for (String person : sortedPeople) {
            System.out.println(person);
        }

        scanner.close();
    }
}