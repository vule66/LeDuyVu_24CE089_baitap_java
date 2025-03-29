import javafx.fxml.FXML;
import javafx.scene.control.TitledPane;

public class Xmlfx {

    @FXML
    private TitledPane titledPane1; // Ví dụ nếu muốn thao tác với TitledPane

    // Phương thức khởi tạo, sẽ tự động chạy khi giao diện được load
    @FXML
    public void initialize() {
        System.out.println("Giao diện đã khởi động thành công!");
    }
}
