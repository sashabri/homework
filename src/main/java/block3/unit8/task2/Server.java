package block3.unit8.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static String socialStatus(int age, String sex){
        if (age < 18) {
            return "Несовершеннолетний";
        }

        if ((sex.equals("М") && age >= 65) || (sex.equals("Ж") && age >= 60)) {
            return "Пенсионер";
        }

        return "Взрослый";
    }

    public static void main(String[] args) throws IOException {
        int port = 8084;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
                ) {
                    System.out.printf("Новое соединение установлено. Порт : %d%n", clientSocket.getPort());

                    out.println(String.format("Добро пожаловать, друг. Твой порт - %d", clientSocket.getPort()));

                    out.println("Укажите ваше имя");

                    final String name = in.readLine();
                    out.println(String.format("Привет, %s.", name));

                    out.println(String.format("%s, укажите ваш возраст", name));

                    final int age = Integer.parseInt(in.readLine());

                    out.println(String.format("%s, укажите ваш пол (М/Ж)", name));

                    final String sex = in.readLine();

                    out.println(String.format("%s, ваш социальный статус - %s", name, socialStatus(age, sex)));
                }
            }
        }
    }
}
