package block3.unit8.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "netology.homework";
        int port = 8084;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ){
            System.out.println(in.readLine());

            System.out.println(in.readLine());

            out.println("Марк Твен");

            System.out.println(in.readLine());

            System.out.println(in.readLine());

            out.println("45");

            System.out.println(in.readLine());

            out.println("М");

            System.out.println(in.readLine());
        }
    }
}
