package lk.ijse.send_mail_using_javafx.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import lk.ijse.send_mail_using_javafx.mail.Mail;

import java.net.URL;
import java.util.ResourceBundle;

public class SecondWindowFormController implements Initializable {
    @FXML
    private AnchorPane pane;
    @FXML
    private JFXTextField txtGmail;

    @FXML
    private JFXTextField txtSubject;

    @FXML
    private JFXTextArea txtMessage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), pane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();


    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        boolean isValid = checkValid();

        if (isValid) {

            Mail mail = new Mail();
            mail.setTo(txtGmail.getText()); //receiver's mail
            mail.setSubject(txtSubject.getText()); //email subject
            mail.setMsg(txtMessage.getText());//email message

            Thread thread = new Thread(mail);
            thread.start();
        }

    }

    @FXML
    void txtGmailOnAction(ActionEvent event) {
        txtSubject.requestFocus();
    }


    @FXML
    void txtSubjectOnAction(ActionEvent event) {
        txtMessage.requestFocus();
    }

    private boolean checkValid() {
       /*Checking whether the email is correct,
       * checking whether the message filed is empty*/

        boolean isValid = true;

        String email = txtGmail.getText();
        if (!email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) {
            txtGmail.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            txtGmail.setStyle(null);
        }


        if (txtMessage.getText().equals("")) {
            txtMessage.setStyle("-fx-border-color: red");
            isValid = false;
        } else {
            txtMessage.setStyle(null);
        }

        return isValid;
    }

    @FXML
    void txtGmailOnKeyPressed(KeyEvent event) {
        checkValid();
    }

    @FXML
    void txtMessageOnKeyPressed(KeyEvent event) {
        checkValid();
    }
}
