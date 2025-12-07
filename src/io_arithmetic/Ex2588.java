package io_arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2588 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int a = Integer.parseInt(br.readLine());
            String b = br.readLine();

            System.out.println(a * (b.charAt(2) - '0'));
            System.out.println(a * (b.charAt(1) - '0'));
            System.out.println(a * (b.charAt(0) - '0'));
            System.out.println(a * Integer.parseInt(b));
        } catch (IOException e) {
        }
    }
}