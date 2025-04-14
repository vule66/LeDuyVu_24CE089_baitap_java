package bai2;

import javafx.beans.property.SimpleStringProperty;

public class EncryptionResult {
    private final SimpleStringProperty encrypted;
    private final SimpleStringProperty decrypted;

    public EncryptionResult(String encrypted, String decrypted) {
        this.encrypted = new SimpleStringProperty(encrypted);
        this.decrypted = new SimpleStringProperty(decrypted);
    }

    public String getEncrypted() {
        return encrypted.get();
    }

    public String getDecrypted() {
        return decrypted.get();
    }
}
