package ru.timurkh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int a = 0;
        int b = 1;
        for (int i = 2; i <= n; ++i) {
            a = a + b;
            // swap
            a = a + b;
            b = a - b;
            a = a - b;
        }
        System.out.println(b);
    }
}
