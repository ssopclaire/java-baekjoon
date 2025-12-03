package io_arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex18108 {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int buddhistYear = Integer.parseInt(br.readLine());
            int adYear = buddhistYear - 543;

            System.out.println(adYear);
        } catch (IOException e) {
        }
    }
}