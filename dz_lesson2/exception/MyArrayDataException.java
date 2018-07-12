package ru.geekbrains.dz_lesson2.exception;

public class MyArrayDataException extends CustomException {

    public MyArrayDataException(int row, int col) {
        super(String.format("Обработка исключений в массиве [%d, %d]", row, col));
    }
}
