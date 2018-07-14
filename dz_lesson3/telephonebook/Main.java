package ru.geekbrains.dz_lesson3.telephonebook;

import java.util.*;

public class Main {

    /*
    * 1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
    *    Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
    *    Посчитать, сколько раз встречается каждое слово.
    *
    * 2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и
    * телефонных номеров. В этот телефонный справочник с помощью метода add() можно
    * добавлять записи, а с помощью метода get() искать номер телефона по фамилии. Следует
    * учесть, что под одной фамилией может быть несколько телефонов (в случае
    * однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
    *
    */

    public static void main(String[] args) {
        String[] words = {"Java", "dog", "set", "cat", "look", "book", "pen","dog", "set", "pencil", "look", "book", "good", };

        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println("Сколько раз встречается каждое слово: ");
        System.out.println(map);
        System.out.println("");



        Set<String> uq = new HashSet<>(Arrays.asList(words));
        System.out.println("Список уникальных слов: ");
        System.out.println(uq);
        System.out.println("");

        //задача 2
        TelephoneBook tb = new TelephoneBook();

        tb.add("Сидоров", "987");
        tb.add("Федоров", "654");
        tb.add("Петров", "321");
        tb.add("Петров", "159");
        tb.add("Петров", "456");

        System.out.println("Телефонный справочник: ");
        System.out.println(tb.get("Петров"));
    }
}
