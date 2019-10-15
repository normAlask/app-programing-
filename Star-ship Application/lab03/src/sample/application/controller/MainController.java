package sample.application.controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.application.model.Fleet;
import java.io.IOException;

/*
This class objective to output the information to the App
 */

public class MainController implements EventHandler<ActionEvent> {
    @FXML TextField myTextField;
    @FXML TextArea myTextArea;
    @FXML
    public void MyButton() throws IOException {
        Fleet fleet = new Fleet();
        fleet.readDataFromFile();
        String paragraph = "";
        String input = myTextField.getText().toString().toLowerCase();
            for (int i = 0; i < 8; i++) {
                if (fleet.getStarshipName(i).toLowerCase().contains(input)) {
                    paragraph += "\n" + fleet.getStarshipName(i);
                    paragraph += fleet.getRegisry(i);
                    paragraph += fleet.getStarshipClass(i);
                    paragraph += fleet.getCrewNumber(i);
                    paragraph += fleet.getAllCrews(i); } }
            if (paragraph.equals("")){ paragraph="Error Ship not found";}
            myTextArea.setText(paragraph);
    } // put the infomation inside diff paragraphs and out it put it to the App using setText



    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
