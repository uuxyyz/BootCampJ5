package com.colvir.lesson01;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String data = getInputData(System.out, System.in);

        System.out.println(String.format("Будет обработана строка %s", data));

        Arrays.stream(data.toLowerCase().split("[^a-zа-я0-9]")).filter(s -> !s.equals("")).
                collect(Collectors.toMap(k -> k, u -> 1, (e, r) -> e + 1)).
                entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).
                forEach(e -> System.out.println(e.getKey()));
    }

    private static String getInputData(PrintStream printStream, InputStream inputStream) {
        printStream.print("Введите строку: ");
        String result = new Scanner(inputStream).nextLine();
        if (result.isEmpty()) {
            return "Семь раз отмерь, 1 раз   отрежь!";
        }
        return result;
    }
}