package com.example.chat_aplikace;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloController {
    public Button send;
    public TextField userInput;
    public String UserMessage;
    public TextArea chatWindow;


    public void send(ActionEvent actionEvent) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime localTime = LocalTime.now();

        System.out.println("Posilam zpravu na server.");
         UserMessage = userInput.getText();
         //pošle message na server---PUT UserMessage
        //vyžádá si tu samou message od serveru----GET UserMessage
        String chatHistory = chatWindow.getText();
        chatWindow.setText( chatHistory + "\n" +
                dtf.format(localTime) + "-" + "Uzivatel 1: "/* + String message */); // String message který si vyžádal od serveru viz 19
    }
}