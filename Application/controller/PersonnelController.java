package Application.controller;

import Application.model.CrewMember;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class PersonnelController {
    @FXML Label lableName1;
    @FXML Label lableName2;
    @FXML Label lableName3;
    @FXML Label lableName4;
    @FXML Label lableName5;
    @FXML Label lableName6;
    @FXML Label lableName7;
    @FXML Label lableName8;
    @FXML ImageView imageView1;
    @FXML ImageView imageView2;
    @FXML ImageView imageView3;
    @FXML ImageView imageView4;
    @FXML ImageView imageView5;
    @FXML ImageView imageView6;
    @FXML ImageView imageView7;
    @FXML ImageView imageView8;
    @FXML Label Welcome;
    @FXML Label Registry;
    String CurrUser;

    /**
     * @params lableName 1-8
     * @params imageView 1-8
     *
     */


    /*
    this function will set and get the user
     */
    public String getCurrentUser() {return CurrUser;}
    public void setCurrentUser(String currUser) {CurrUser = currUser;}

    /*
    this function will check the Registory for each member
     */
    public ArrayList<CrewMember> checkRegs(String reg, ArrayList<CrewMember> crewMembers){
        ArrayList<CrewMember> NewMember = new ArrayList<CrewMember>();
        for(int i =0; i < crewMembers.size(); i++){
            if(crewMembers.get(i).getRegistry().equals(reg)) {
                CrewMember crewMember = crewMembers.get(i);
                NewMember.add(crewMember); }
        }
        return  NewMember;
    }

    /*

   this function will load in the infomtion
   for all the members and set them into Arraylist of lables and images
     */
    public void loadInfo() throws FileNotFoundException{

        ArrayList<CrewMember> crews = new ArrayList<CrewMember>();
        CrewMember crewMembers = new CrewMember();
        crews = crewMembers.ReadPersonalInfo();
        ArrayList<CrewMember> newCrews = new ArrayList<CrewMember>();
        String WhosIn="";


        for( int i=0; i < crews.size(); i++){
            if(crews.get(i).getLastName().toLowerCase().equals(getCurrentUser())){
                WhosIn = crews.get(i).getRegistry();
            }
        }
        newCrews = checkRegs(WhosIn,crews);
        Registry.setText(WhosIn );

        if(newCrews.size() > 0 ){
            ArrayList<Label> labels = new ArrayList<Label>();
             labels=getLabs();
             setLabls(newCrews, labels);
            ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
            imageViews = getImage();
            setPic(newCrews, imageViews);
        }
    }

    /*
    this function will add 8 labels for each of the memebers into Arraylist
     */
    public ArrayList<Label> getLabs(){
        ArrayList<Label> labels = new ArrayList<Label>();
        labels.add(lableName1);
        labels.add(lableName2);
        labels.add(lableName3);
        labels.add(lableName4);
        labels.add(lableName5);
        labels.add(lableName6);
        labels.add(lableName7);
        labels.add(lableName8);
        return labels;
    }

     /*
    this function will add 8 Images for each of the memebers into Arraylist
     */

    public ArrayList<ImageView> getImage() {
        ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
        imageViews.add(imageView1);
        imageViews.add(imageView2);
        imageViews.add(imageView3);
        imageViews.add(imageView4);
        imageViews.add(imageView5);
        imageViews.add(imageView6);
        imageViews.add(imageView7);
        imageViews.add(imageView8);
        return imageViews;
    }

    /*
    This Function will set all the labels
     */

    public void  setLabls(ArrayList<CrewMember> crewMembers,ArrayList<Label> labels){
        for(int i=0; i < labels.size(); i++){
            labels.get(i).setText(crewMembers.get(i).getName()+" \n" +crewMembers.get(i).getPosition());
        }
    }

     /*
    This Function will set all the pictures
     */

    public void setPic(ArrayList<CrewMember> crewMembers,ArrayList<ImageView> imageViews) throws FileNotFoundException{
        for(int i=0; i < imageViews.size(); i++){
            imageViews.get(i).setImage(new Image(crewMembers.get(i).getUrlImage()));
        }
    }

 /*
    This Function responsible for changing the Scene
     */

    public void changeScene(ActionEvent event) throws IOException {
        Parent tablePareant =FXMLLoader.load(getClass().getResource("../login.fxml"));
        Scene Secne2 = new Scene(tablePareant);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(Secne2);
        window.show();
    }

     /*
    This Function responsible for changing the Scean  back to the login
     */

    @FXML public void LogOut(ActionEvent event) {
        try {
            changeScene(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
