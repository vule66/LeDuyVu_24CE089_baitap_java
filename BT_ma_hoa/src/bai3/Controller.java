package bai3;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Controller {

    @FXML
    private TableColumn<DataRow, String> colGiaiMa;

    @FXML
    private TableColumn<DataRow, String> colMahoa;

    @FXML
    private Button enter;

    @FXML
    private TextField input;

    @FXML
    private TableView<DataRow> tabileview;

    private ObservableList<DataRow> dataList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        colMahoa.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getEncrypted()));
        colGiaiMa.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(cellData.getValue().getDecrypted()));
        tabileview.setItems(dataList);

        enter.setOnAction(e -> {
            String inputText = input.getText();

            if (inputText == null || inputText.isEmpty()) {
                return;
            }

            Thread encryptionThread = new Thread(() -> {
                String encoded = Base64.getEncoder().encodeToString(inputText.getBytes(StandardCharsets.UTF_8));

                Thread decryptionThread = new Thread(() -> {
                    byte[] decodedBytes = Base64.getDecoder().decode(encoded);
                    String decoded = new String(decodedBytes, StandardCharsets.UTF_8);

                    Platform.runLater(() -> {
                        dataList.add(new DataRow(encoded, decoded));
                    });
                });

                decryptionThread.start();
            });

            encryptionThread.start();
        });
    }
}
