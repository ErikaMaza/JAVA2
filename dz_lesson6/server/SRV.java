package ru.geekbrains.dz_lesson6.version_2.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SRV {
    BufferedReader in = null;
    PrintWriter out = null;
    ServerSocket serverSocket = null;
    Socket socket = null;
    String input;
    BufferedReader console = null;

    void start() {
        try {
            serverSocket = new ServerSocket(1111);
        } catch (IOException e) {
            System.out.println("Не удается открыть порт 1111");
            System.exit(1);
        }
        System.out.print("Сервер запущен. Ожидание клиента...");
    }

    void catchClient() throws IOException {
        try {
            socket = serverSocket.accept();
            System.out.println("Клиент подключен");
        } catch (IOException e) {
            System.out.println("Не могу принять");
            System.exit(1);
        }

        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(),true);

        System.out.println("Ожидание сообщений...");
    }

    void sendMessage(String msg) throws IOException {
        if (msg.equalsIgnoreCase("Выход")) close();
        out.println("S ::: " + msg);
        System.out.println(msg);
    }

    void close() throws IOException {
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }

    void writeToConsole() throws IOException {
        while (true) {
            console = new BufferedReader(new InputStreamReader(System.in));
            String txt = console.readLine();
            sendMessage(txt);
        }
    }
}
