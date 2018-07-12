package ru.geekbrains.dz_lesson2.exception;

public class MyArraySizeException extends CustomException{

    public MyArraySizeException() {
        super("Массив должен быть размером 4x4");
    }
}
