package com.colvir.lesson01;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String data = getInputData();

        System.out.printf("Будет обработана строка %s%n", data);

        Arrays.stream(data.toLowerCase().split("[^a-zа-я0-9]")).filter(s -> !s.isEmpty())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey).forEach(System.out::println);
    }

    private static String getInputData() {
        System.out.print("Введите строку: ");
        String result = new Scanner(System.in).nextLine();
        if (result.isEmpty()) {
            return "Семь раз отмерь, 1 раз   отрежь!";
        }
        return result;
    }
}