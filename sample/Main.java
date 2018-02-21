package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("bola.fxml"));
        Parent root = (Parent)loader.load();
        //Parent root = FXMLLoader.load(getClass().getResource("bola.fxml"));
        Controller controller = (Controller)loader.getController();
        Scene sc = new Scene(root);

        primaryStage.setTitle("La piloteta");
        primaryStage.setScene(sc);
        primaryStage.show();
        controller.setScene(sc);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
