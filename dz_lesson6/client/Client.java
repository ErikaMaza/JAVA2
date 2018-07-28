package ru.geekbrains.dz_lesson6.version_2.client;

import java.io.*;


public class Client {
    public static void main(String[] args) throws IOException {
        CLI cli = new CLI();
        System.out.println("Клиент запущен. Подключение к localhost: 1111");

        new Thread() {
            public void run() {
                try {
                    cli.readMSG();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    cli.sendMSG();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}