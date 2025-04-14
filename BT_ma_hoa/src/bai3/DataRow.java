package bai3;

public class DataRow {
    private String encrypted;
    private String decrypted;

    public DataRow(String encrypted, String decrypted) {
        this.encrypted = encrypted;
        this.decrypted = decrypted;
    }

    public String getEncrypted() {
        return encrypted;
    }

    public String getDecrypted() {
        return decrypted;
    }
}
