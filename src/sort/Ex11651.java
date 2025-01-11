package sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex11651 {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();

            List<Point> points = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                points.add(new Point(x, y));
            }

            points.sort((p1, p2) -> {
                if (p1.y == p2.y) {
                    return Integer.compare(p1.x, p2.x);
                }
                return Integer.compare(p1.y, p2.y);
            });

            for (Point point : points) {
                System.out.println(point.x + " " + point.y);
            }
        } catch (Exception e) {
        }
    }
}