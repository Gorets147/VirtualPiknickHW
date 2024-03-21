package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputTxt = new File("src/main/java/org/example/input.txt");
        FileInputStream inputStream = new FileInputStream(inputTxt);
        byte[] buffer = new byte[1024];
        int bytesRead;
        String multifrut = "";
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            multifrut = multifrut + new String(buffer, 0, bytesRead);
        }
        inputStream.close();

        multifrut = multifrut.replaceAll("\\s+", " ");
        String[] frutArr = multifrut.split(" ");
        System.out.println(Arrays.toString(frutArr));

        System.out.println("Всего в файле "+ frutArr.length + " слов");
        int max = 0;
        int sec = 0;
        for (int i = 0; i < frutArr.length; i++) {
            if (frutArr[i].length() > max){
                max = i;
            }
            if (frutArr[i].length() == frutArr[max].length()){
                sec = i;
            }
        }
        System.out.println("Самое длинное слово " + frutArr[max] +" "+ frutArr[max].length()+ " символов");
        System.out.println("Тоже длинное слово " + frutArr[sec]+" "+ frutArr[sec].length()+ " символов");

        Map<String, Integer> basket = new HashMap<>();
        Set<String> unique = new HashSet<>(List.of(frutArr));
        for (String key : unique) {
            basket.put(key, Collections.frequency(List.of(frutArr), key));
        }
        System.out.println(basket);
    }
}