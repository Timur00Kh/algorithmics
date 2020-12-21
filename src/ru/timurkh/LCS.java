package ru.timurkh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LCS {

    static BufferedReader reader;
    static BufferedWriter writer;

    static {
        try {
            reader = new BufferedReader(new FileReader(new File("src/main/java/lcs/input.txt")));
            writer = new BufferedWriter(new FileWriter(new File("src/main/java/lcs/output.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {


        int[] x = processInputLine(reader.readLine());
        int[] y = processInputLine(reader.readLine());

        reader.close();

        if (x.length == 0 || y.length == 0) {
            writer.write("[]");
        }

        int[][] result = new int[x.length + 1][y.length + 1];

        for (int i = 1; i <= x.length; i++) {
            for (int j = 1; j <= y.length; j++) {
                // Если элементы обоих массивов равны, то берем длину предыдущей НОП и добавляем к ней текущий элемент
                if (x[i - 1] == y[j - 1]) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                    // Берем максимальную длину НОП из 2 предыдущих (по строке и столбцу)
                    result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
                }
            }
        }

        List<String> way = new ArrayList<>();
        int n = x.length, m = y.length;

        while (n > 0 && m > 0) {
            // Если элементы равны, то добавляем его к НОП
            if (x[n - 1] == y[m - 1]) {
                way.add(String.valueOf(x[n - 1]));
                n--;
                m--;
            }
            // уменьшаем счетчики, чтобы двигаться по матрице, приближаясь к НОП, при которой элементы были равны
            else if (result[n - 1][m] > result[n][m - 1])
                n--;
            else
                m--;
        }

        for (int i = way.size() - 1; i >= 0; i--) {
            writer.write(way.get(i).concat(" "));
        }
        writer.close();
    }

    public static int[] processInputLine(String line) {
        String[] numbers = line.trim().split(" ");
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        return array;
    }
}
