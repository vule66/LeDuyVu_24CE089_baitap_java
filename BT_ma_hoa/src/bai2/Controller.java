package bai2;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML private TableColumn<EncryptionResult, String> AESDecrypted;
    @FXML private TableColumn<EncryptionResult, String> AESEncrypted;
    @FXML private TableView<EncryptionResult> AEStable;

    @FXML private TableColumn<EncryptionResult, String> RSADecrypted;
    @FXML private TableColumn<EncryptionResult, String> RSAEncrypted;
    @FXML private TableView<EncryptionResult> RSAtable;

    @FXML private Button buttonMahoa;
    @FXML private TextField inputDulieu;

    private AES aes;
    private RSA rsa;

    public void initialize() {

        aes = new AES();
        rsa = new RSA();

        AESEncrypted.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEncrypted()));
        AESDecrypted.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDecrypted()));
        RSAEncrypted.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEncrypted()));
        RSADecrypted.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDecrypted()));

        buttonMahoa.setOnAction(e -> handleEncrypt());
    }

    private void handleEncrypt() {
        String data = inputDulieu.getText();
        if (data == null || data.isEmpty()) return;

        String aesEncrypted = aes.encrypt(data);
        String aesDecrypted = aes.decrypt(aesEncrypted);
        String rsaEncrypted = rsa.encrypt(data);
        String rsaDecrypted = rsa.decrypt(rsaEncrypted);

        ObservableList<EncryptionResult> aesList = FXCollections.observableArrayList();
        aesList.add(new EncryptionResult(aesEncrypted, aesDecrypted));
        AEStable.setItems(aesList);

        ObservableList<EncryptionResult> rsaList = FXCollections.observableArrayList();
        rsaList.add(new EncryptionResult(rsaEncrypted, rsaDecrypted));
        RSAtable.setItems(rsaList);
    }
}
