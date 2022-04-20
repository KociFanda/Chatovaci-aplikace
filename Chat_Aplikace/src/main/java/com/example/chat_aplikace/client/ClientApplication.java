package com.example.chat_aplikace.client;


import com.example.chat_aplikace.shared.Message;


import java.io.*;
import java.net.Socket;

public class ClientApplication {

    public static void writeObjectToOutputStream(OutputStream outputStream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Message message = new Message();
        message.setCommand("SEND_DATA");
        message.setData("data data need more data");

        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
        objectOutputStream.close();
    }


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        BufferedReader inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter outputStream = new PrintWriter(socket.getOutputStream(), true);
        writeObjectToOutputStream(socket.getOutputStream());
    }

}

