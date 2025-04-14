package bai1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Controller {

    @FXML
    private TableColumn<User, String> taikhoang;

    @FXML
    private TableColumn<User, String> matkhau;

    @FXML
    private TableColumn<User, String> Mahoa;

    @FXML
    private TextField inputMatKhau;

    @FXML
    private TextField inputTaiKhoang;

    @FXML
    private Button nutDangNhap;

    @FXML
    private TableView<User> tabbleView;

    private final ObservableList<User> users = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        taikhoang.setCellValueFactory(data -> data.getValue().taiKhoanProperty());
        matkhau.setCellValueFactory(data -> data.getValue().matKhauProperty());
        Mahoa.setCellValueFactory(data -> data.getValue().maHoaProperty());

        tabbleView.setItems(users);

        nutDangNhap.setOnAction(event -> handleDangNhap());
    }

    private void handleDangNhap() {
        String tk = inputTaiKhoang.getText();
        String mk = inputMatKhau.getText();
        String mk_mahoa = hashPassword(mk);

        if (!tk.isEmpty() && !mk.isEmpty()) {
            users.add(new User(tk, mk, mk_mahoa));
            inputTaiKhoang.clear();
            inputMatKhau.clear();
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hex = new StringBuilder();
            for (byte b : hash) {
                hex.append(String.format("%02x", b));
            }
            return hex.toString();
        } catch (NoSuchAlgorithmException e) {
            return "Lỗi mã hóa!";
        }
    }
}
