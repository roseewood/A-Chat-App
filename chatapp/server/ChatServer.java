package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import common.Constants;

public class ChatServer {

    private static List<ClientHandler> clients = new ArrayList<>();

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(Constants.PORT);

            System.out.println("Server started on port " + Constants.PORT);

            while (true) {

                Socket socket = serverSocket.accept();
                System.out.println("New client connected");

                ClientHandler handler = new ClientHandler(socket, clients);

                clients.add(handler);

                new Thread(handler).start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}