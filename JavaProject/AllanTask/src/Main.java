import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/Login.fxml"));
        primaryStage.setTitle("AllanTask - Login");
        primaryStage.setScene(new Scene(root, 261, 237));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
