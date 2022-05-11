package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Exchange;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import java.nio.file.NoSuchFileException;
import java.util.ResourceBundle;

public class ExchangeController implements Initializable {

    @FXML
    private TextField amountField;

    @FXML
    private Label resultBox;

    @FXML
    private ComboBox<String> fromBox;

    @FXML
    private ComboBox<String> toBox;

    @FXML
    private ImageView img;

    @FXML
    private Label noFile;

    //Exchange instance
    private Exchange exchangeCurrency;

    //fill combobox
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("USD", "EUR", "GBP", "HUF");
        fromBox.setItems(list);
        toBox.setItems(list);
        exchangeCurrency = new Exchange();

        File file = new File("currency.jpg");
        Image image = new Image(file.toURI().toString());
        img.setImage(image);
    }

    //HASHMAP megoldas
    public void calculate(ActionEvent actionEvent) throws IOException {
        Button button = (Button) actionEvent.getSource();

        if (button.getId().equals("CalculateButton")) {
            if (amountField.getText().isEmpty()) {
                resultBox.setText("no entered amount");
//            }else{
//                resultBox.setText(exchangeCurrency.CalculateCurrency(amountField.getText(), (fromBox.getValue() + toBox.getValue())));
//                exchangeCurrency.SavingTheChangedValues(amountField.getText(),fromBox.getValue(),toBox.getValue(),resultBox.getText());
            } else if (fromBox.getValue() == null || toBox.getValue() == null) {
                resultBox.setText("Select a valid currency");
            } else try {
                resultBox.setText(exchangeCurrency.CalculateCurrency(amountField.getText(), (fromBox.getValue() + toBox.getValue())));
                exchangeCurrency.SavingTheChangedValues(amountField.getText(), fromBox.getValue(), toBox.getValue(), resultBox.getText());
            } catch (NumberFormatException e) {
                resultBox.setText("Invalid amount");
            }
        }
    }


    public void historyShow(ActionEvent actionEvent) throws IOException {

            Parent root = FXMLLoader.load(getClass().getResource("/History.fxml"));
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("History file");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();

    }
}

