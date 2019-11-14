package Application.controller;

import Application.model.CrewMember;
import Application.model.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController implements EventHandler<javafx.event.ActionEvent> {

    @FXML
    TextField username;
    @FXML
    PasswordField Password;
    @FXML
    Label AccessMsg;


    /*

     @FXML
    TextField username;
    @FXML
    PasswordField Password;
    @FXML
    Label AccessMsg;

     */


   /*
   this fcunctin will ckeck if the user name and password match is so change the Secen other wiser returen Error
   Massage
    */
    @FXML
    public void Button(ActionEvent event) throws IOException {
        User user = new User();
        user.ReadInUsers();
        if (user.validate(username.getText(), Password.getText()) == true) {
            AccessMsg.setText("Success");
            AccessMsg.setTextFill(Color.web("green"));
            changeScreen(event);
        } else {
            AccessMsg.setText("Sorry wrong password or userName Try Again ");
            AccessMsg.setTextFill(Color.web("red"));
        }
    }

     /*
    This Function responsible for changing the Scene
     */

    @FXML
    public void changeScreen(javafx.event.ActionEvent event) throws IOException {
        Stage secondaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Personnel.fxml"));
        Parent root = loader.load();
        PersonnelController controller = loader.getController();
        controller.setCurrentUser(username.getText());
        controller.loadInfo();
        controller.Welcome.setText("Welcome "+username.getText());
        secondaryStage.setScene(new Scene(root, 800 , 800));
        secondaryStage.show();

    }


    @Override
    public void handle(javafx.event.ActionEvent actionEvent) {
    }

}