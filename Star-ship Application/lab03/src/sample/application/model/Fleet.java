package sample.application.model;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/*
The overview of this class will be to read information from the files and Arraylist
- Set them in to groups
- Compare information
- out the desierd information
@pram name private
@pram classStarship
@pram paragraph
 */

public class Fleet {
    private String name;
    private String classStarship;
    ArrayList<Starship> starships = new ArrayList<Starship>();
    CrewMember crewMember = new CrewMember();
    private String paragraph;

    public Fleet() {} // defult consrtactor

    public Fleet(String name){this.name=name;} // constactor to return the name

    public String getStarshipName(int i){return starships.get(i).getName();} // method to get the getStarshipName

    public String getRegisry(int i){paragraph = "[" + starships.get(i).getRegistry() + "], \n";
        return paragraph;} // method to get the getRegisry

    public String getStarshipClass(int i){
        paragraph = "Class: " + starships.get(i).getStarshipClass() + ", ";
        return paragraph;
    } // method to get the getStarshipClass

    public String getCrewNumber(int i){
        paragraph = "Crew: " + this.starships.get(i).crewMembers.size();
        return paragraph;}  // method to fet the CrewNumbers to output in the Application

    public String getAllCrews(int i){
        paragraph = "\n";

        for(int j = 0; j < this.starships.get(i).crewMembers.size(); j++){
            paragraph += " - " +
                            starships.get(i).crewMembers.get(j).getRank() + " " +
                            starships.get(i).crewMembers.get(j).getName() + ", " +
                            starships.get(i).crewMembers.get(j).getPosition() + " (" +
                            starships.get(i).crewMembers.get(j).getSpecies() + ") " +
                            "\n";}
        return paragraph;}
/*
This Function will get all CewrsInformation and set them into pices of desierd information
it will output
- The Rank
- Name
- Position
- species

 */
    ArrayList<Starship> getStarshipByName(String name){ return starships; }
    // get the informaton by name from the arrayList


    public void readDataFromFile() throws FileNotFoundException {
        Scanner scnr = new Scanner(new File("/C:/Users/noora/IdeaProjects/lab03/src/sample/fleet.csv"));
        scnr.useDelimiter(Pattern.compile("[\n|,]"));
        int i = 0;
        while(scnr.hasNext()) {
            starships.add(new Starship());
            starships.get(i).setName(scnr.next());
            starships.get(i).setRegistry(scnr.next());
            starships.get(i).setStarshipClass(scnr.next());
            i++; }

        Scanner scnr1 = new Scanner(new File("C:/Users/noora/IdeaProjects/lab03/src/sample/personnel.csv"));
        scnr1.useDelimiter(Pattern.compile("[\n|,]"));
        i = 0;
        ArrayList<CrewMember> crewMembersTemp = new ArrayList<CrewMember>();
        while(scnr1.hasNext()) {
            crewMembersTemp.add(new CrewMember());
            crewMembersTemp.get(i).setName(scnr1.next());
            crewMembersTemp.get(i).setRank(scnr1.next());
            crewMembersTemp.get(i).setPosition(scnr1.next());
            crewMembersTemp.get(i).setRegistry(scnr1.next());
            crewMembersTemp.get(i).setSpecies(scnr1.next());
            i++;
        }

        for(int a = 0; a < starships.size(); a++){
            for(int b = 0; b < crewMembersTemp.size(); b++ ){
                if(starships.get(a).getRegistry().equals( crewMembersTemp.get(b).getRegistry() )){
                    starships.get(a).crewMembers.add(crewMembersTemp.get(b));
                }
            }
        }

        this.starships = starships;
    }
}

/*
This Method will read the information  using scanner from  both  fleet.csv and personnel.csv
line by line it will useDelimiter to read each token of information
I will use a for loop to go through the file to read every information
 */


