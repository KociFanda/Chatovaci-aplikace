package com.example.chat_aplikace;

import com.example.chat_aplikace.client.ClientApplication;
import com.example.chat_aplikace.server.ServerApplication;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class MainChat extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainChat.class.getResource("main-chat-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("The Chatting of big chungus");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerApplication.main(args);
        ClientApplication.main(args);
        launch();
    }
}