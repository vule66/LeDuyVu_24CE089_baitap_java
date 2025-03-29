import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class gui extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mai.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        primaryStage.setTitle("Quản Lý Sách");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
