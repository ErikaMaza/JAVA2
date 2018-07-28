package ru.geekbrains.dz_lesson6.version_2.server;

import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {
        SRV s = new SRV();
        s.start();
        s.catchClient();
        new Thread() {
            public void run() {
                while (true) {
                    String txt = null;
                    try {
                        txt = s.in.readLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (txt != null) {
                        try {
                            s.sendMessage(txt);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    s.writeToConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //s.writeToConsole();
    }
}