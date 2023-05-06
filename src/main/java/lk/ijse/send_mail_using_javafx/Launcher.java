package lk.ijse.send_mail_using_javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("/view/first_window_form.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Send Mail - Welcome !!!");
        Image icon = new Image(getClass().getResourceAsStream("/img/logo.png")); //Setting the icon to the stage
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}