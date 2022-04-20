package com.example.chat_aplikace.server;

import com.example.chat_aplikace.shared.Message;


import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ConnectionThread extends Thread {

    public static final List<Socket> sockets = new ArrayList<>();

    private final Socket socket;

    public ConnectionThread(Socket socket, ServerSocket server) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (!socket.isClosed()) {
            System.out.println("New connection from " + socket.getInetAddress());
            try {
                ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
                System.out.println("New message from " + socket.getInetAddress());
                Message message = (Message) input.readObject();
                for (Socket s : sockets) {
                    if(socket.isClosed()) {
                        System.exit(0);
                    }
                    System.out.println("Sending message to " + s.getInetAddress());
                    ObjectOutputStream output = new ObjectOutputStream(s.getOutputStream());
                    output.writeObject(message);
                    output.flush();
                }
                System.out.println("Message sent to " + sockets.size() + " clients");

            } catch (Exception e) {
                System.out.println("Error while reading message from " + socket.getInetAddress());
                e.printStackTrace();
            }
        }
    }

}
