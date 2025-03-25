package stringutils;

import java.io.IOException;

public class Ex11654 {
    public static void main(String[] args) {
        try {
            int ascii = System.in.read();

            System.out.println(ascii);
        } catch (IOException e) {
        }
    }
}