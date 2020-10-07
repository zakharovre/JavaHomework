package homework12;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Controller {

    @FXML
    private ListView<String> ContactList;

    @FXML
    private TextArea MessagesArea;

    @FXML
    private TextField TextInput;

    @FXML
    private Button SendButton;

    @FXML
    void initialize(){
        ContactList.setItems(FXCollections.observableList(Main.Contacts));
        SendButton.setOnAction(event -> sendMessage());
        TextInput.setOnAction(event -> sendMessage());
    }
    void sendMessage(){
        MessagesArea.appendText(new SimpleDateFormat("[HH:mm:ss] ").format(new Date()));
        MessagesArea.appendText(Main.userName + ": ");
        MessagesArea.appendText(TextInput.getText());
        MessagesArea.appendText(System.lineSeparator());
        TextInput.clear();
    }
}



