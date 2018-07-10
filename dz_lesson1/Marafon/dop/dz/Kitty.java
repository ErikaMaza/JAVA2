package dz_lesson1.Marafon.dop.dz;

/*
* Создать Пять котов и 1 хозяина,
* у хозяина должен быть список имен котов (массив) собрать все данные
*
 */


public class Kitty {
    public String name;

    public String getName() {
        return name;
    }

    public Kitty(String name, Kitty kitty) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Кот: " + name;
    }
}

