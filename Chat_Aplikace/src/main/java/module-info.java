module com.example.chat_aplikace {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chat_aplikace to javafx.fxml;
    exports com.example.chat_aplikace;
}