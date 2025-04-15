package qldh;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerView {

    @FXML
    private ComboBox<?> customerComboBox;

    @FXML
    private TableView<?> productTableView;

    @FXML
    private TextField quantityField;

    @FXML
    void AddProduct(ActionEvent event) {
        System.out.println("thêm sản phẩm");
    }

    @FXML
    void CreatOrder(ActionEvent event) {
        System.out.println("Đã thêm");
    }

    @FXML
    void nhapsoluong(ActionEvent event) {
        System.out.println("chọn số lượng");
    }

}
