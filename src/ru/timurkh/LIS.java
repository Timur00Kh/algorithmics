package ru.timurkh;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LIS {

    static BufferedReader reader;
    static BufferedWriter writer;

    static {
        try {
            reader = new BufferedReader(new FileReader(new File("src/main/java/lis/input.txt")));
            writer = new BufferedWriter(new FileWriter(new File("src/main/java/lis/output.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {


        int[] x = processInputLine(reader.readLine());

        reader.close();

        int[] result = new int[x.length];
        Arrays.fill(result, 1);

        for (int i = 1; i < x.length; i++) {
            result[i] = 1;
            for (int j = 0; j < i; j++) {
                if (x[i] > x[j]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }

        List<String> way = new ArrayList<>();
        int n = x.length, m = x.length;
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

