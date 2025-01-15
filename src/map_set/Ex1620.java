package map_set;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex1620 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        scanner.nextLine();

        Map<String, Integer> nameToNumber = new HashMap<>();
        Map<Integer, String> numberToName = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            nameToNumber.put(name, i);
            numberToName.put(i, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String query = scanner.nextLine();
            if (isNumeric(query)) {
                int number = Integer.parseInt(query);
                sb.append(numberToName.get(number)).append("\n");
            } else {
                sb.append(nameToNumber.get(query)).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}