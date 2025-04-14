package bai1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private final StringProperty taiKhoan;
    private final StringProperty matKhau;
    private final StringProperty maHoa;

    public User(String taiKhoan, String matKhau, String maHoa) {
        this.taiKhoan = new SimpleStringProperty(taiKhoan);
        this.matKhau = new SimpleStringProperty(matKhau);
        this.maHoa = new SimpleStringProperty(maHoa);
    }

    public StringProperty taiKhoanProperty() {
        return taiKhoan;
    }

    public StringProperty matKhauProperty() {
        return matKhau;
    }

    public StringProperty maHoaProperty() {
        return maHoa;
    }
}
