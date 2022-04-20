package com.example.chat_aplikace.server;

import com.example.chat_aplikace.shared.Message;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static com.example.chat_aplikace.server.ConnectionThread.sockets;

public class ServerApplication {

    public static void readObjectFromInput(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
       /* while (objectInputStream.available() < 0) {
            // aktivní čekání / busy waiting
        }*/

        Message message = (Message) objectInputStream.readObject();
        System.out.println(message);
        System.out.println(message.getCommand());
        System.out.println(message.getData());
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");
        while (!serverSocket.isClosed()) {
            System.out.println("Waiting for connection");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Connection accepted");
            ConnectionThread connectionThread = new ConnectionThread(clientSocket, serverSocket);
            System.out.println("Connection thread created");
            synchronized (ConnectionThread.class) {
                sockets.add(clientSocket);
                System.out.println("Sockets: " + sockets.size());
            }
            connectionThread.start();
            System.out.println("Connection thread started");
            readObjectFromInput(clientSocket.getInputStream());
            System.out.println("Message: " + clientSocket.getInputStream());
        }

    }
}

