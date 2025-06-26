package advanced2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex2108 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int[] numbers = new int[n];
            int[] counts = new int[8001];

            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());

                numbers[i] = num;
                sum += num;

                counts[num + 4000]++;

                if (num > max) max = num;
                if (num < min) min = num;
            }

            int mean = (int) Math.round((double) sum / n);

            Arrays.sort(numbers);
            int median = numbers[n / 2];

            int maxFreq = 0;
            for (int freq : counts) {
                if (freq > maxFreq) {
                    maxFreq = freq;
                }
            }

            int mode = 0;
            boolean first = true;

            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == maxFreq) {
                    if (first) {
                        mode = i - 4000;
                        first = false;
                    } else {
                        mode = i - 4000;
                        break;
                    }
                }
            }

            int range = max - min;

            System.out.println(mean);
            System.out.println(median);
            System.out.println(mode);
            System.out.println(range);
        } catch (IOException e) {
        }
    }
}