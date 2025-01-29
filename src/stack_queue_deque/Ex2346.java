package stack_queue_deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Ex2346 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            LinkedList<int[]> balloons = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                balloons.add(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            StringBuilder sb = new StringBuilder();
            ListIterator<int[]> iterator = balloons.listIterator();

            while (!balloons.isEmpty()) {
                if (!iterator.hasNext()) {
                    iterator = balloons.listIterator();
                }
                int[] current = iterator.next();
                iterator.remove();
                sb.append(current[0]).append(" ");

                int move = current[1];

                if (balloons.isEmpty()) break;

                if (move > 0) {
                    for (int i = 0; i < move - 1; i++) {
                        if (!iterator.hasNext()) {
                            iterator = balloons.listIterator();
                        }
                        iterator.next();
                    }
                } else {
                    for (int i = 0; i < Math.abs(move); i++) {
                        if (!iterator.hasPrevious()) {
                            iterator = balloons.listIterator(balloons.size());
                        }
                        iterator.previous();
                    }
                }
            }

            System.out.println(sb.toString().trim());
        } catch (IOException e) {
        }
    }
}