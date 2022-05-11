package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Exchange;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.File;
import java.nio.file.NoSuchFileException;

public class HistoryController {

    @FXML
    private TextArea showHistoryText;

    private Exchange exchangeCurrency;

    @FXML
    public void initialize() throws IOException {
        exchangeCurrency = new Exchange();
        try {
            showHistoryText.setText(exchangeCurrency.ReadingTheChangedValues());
        } catch (NoSuchFileException e) {
            showHistoryText.setText("First use the converter :)\nI have no data to show you");
        }
    }

    public void deleteData(@NotNull ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();
        //delete button + main window
        if (button.getId().equals("deleteButton")) {
            File deletion = new File("CurrencyExchangeSaveFile.txt");
            deletion.delete();

            Parent root = FXMLLoader.load(getClass().getResource("/ExchangeApplication.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Exchange Application");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
    }
}
    public void goingBack(ActionEvent actionEvent) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/ExchangeApplication.fxml"));
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Exchange Application");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
;
