package lk.ijse.send_mail_using_javafx.controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FirstWindowFormController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private JFXButton btnStart;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), root);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    @FXML
    public void btnOnAction(ActionEvent actionEvent) {

        try {
           AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/second_window_form.fxml"));

        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Send Mail");
        stage.centerOnScreen();
        stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void onMouseEnterd(MouseEvent event) {
        DropShadow glow = new DropShadow();
        glow.setColor(Color.CORNFLOWERBLUE);
        glow.setWidth(20);
        glow.setHeight(20);
        glow.setRadius(20);
        btnStart.setEffect(glow);
    }
    @FXML
    void onMouseExited(MouseEvent event) {
        btnStart.setEffect(null);
    }
}
