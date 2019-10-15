/*
Name: Noor Alaskari
Class: Application programing
Professor: Tanvir Irfan Chowdhury
Date: 10/04/2019
Program objective: To read in the information using a files and out put it in desierd fashion in the
applicatiion for the users.
 */

package sample.application;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        primaryStage.setTitle("Lab3");
        primaryStage.setScene(new Scene(root, 1000, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
