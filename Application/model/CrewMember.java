package Application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CrewMember {
    String Name;
    String Position;
    String Rank;
    String Registry;
    String Species;
    String UserLastName;
    String Imageurl;

    /**
     * @param Name
     * @param Position
     * @param Rank
     * @param Species
     * @param Imageurl
     * @param UserLastName
     * @param Imageurl
     *
     */
    ArrayList<CrewMember> crew = new ArrayList<CrewMember>();

    /**
     * @return name
     */
        public String getName() {
            return Name;
        }
    /**
     * @param name
     */

        public void setName(String name) {
            this.Name = name;
        }

    /**
     * @return Position
     */

        public String getPosition() {
            return Position;
        }
    /**
     * @param position
     */


        public void setPosition(String position) {
            this.Position = position;
        }

    /**
     * @return rank
     */

    public String getRank() {
            return Rank;
        }

    /**
     * @param  rank
     */

    public void setRank(String rank) {
            this.Rank = rank;
        }

    /**
     * @return registry
     */

    public String getRegistry() {
            return Registry;
        }

    /**
     * @param registry
     */

        public void setRegistry(String registry) {this.Registry = registry;}

    /**
     * @return registry
     */

        public String getSpecies() { return Species;}

    /**
     * @return species
     */

        public void setSpecies(String species) {
            this.Species = species;
        }
    /**
     * @params species
     */

        public ArrayList<CrewMember> getCrewMembers() {
            return crew;
        }
    /**
     * @return crew
     */

        public void setCrewMembers(ArrayList<CrewMember> crewMembers) {
            this.crew = crewMembers;
        }
    /**
     * @params  crew
     */

        public String getLastName() {
            return UserLastName;
        }
    /**
     * @return serLastName
     */

        public void setLastName(String lastName) {this.UserLastName = lastName;}
    /**
     * @params serLastName
     */

        public String getUrlImage() {
            return Imageurl;
        }
    /**
     * @return Imageurl
     */

        public void setUrlImage(String urlImage) {
            this.Imageurl= urlImage;
        }
    /**
     * @params Imageurl
     */


    /*

    this function will read all information from personal and the images file for later useage
     */

    public ArrayList<CrewMember> ReadPersonalInfo() throws FileNotFoundException{
        Scanner scan = new Scanner(
                new File
          ("C:/Users/noora/OneDrive/Desktop/tpd972-lab4/src/Application/data/personnel.csv"));
        scan.useDelimiter(Pattern.compile("[\n|,]"));
        int index = 0;
//        CrewMember person = new CrewMember();
//        crew = new ArrayList<CrewMember>();
        while (scan.hasNext()) {
            crew.add(new CrewMember());
            crew.get(index).setName(scan.next());
            crew.get(index).setPosition(scan.next());
            crew.get(index).setRank(scan.next());
            crew.get(index).setRegistry(scan.next());
            crew.get(index).setSpecies(scan.next());
            crew.get(index).setLastName(crew.get(index).getName().substring
                    (crew.get(index).getName().lastIndexOf(" ")+1));
            crew.get(index).setUrlImage("Application/images/"+
                    crew.get(index).getLastName().toLowerCase() + ".jpg");
            if(crew.get(index).getUrlImage().equals("Application/images/forge.jpg")){
                crew.get(index).setUrlImage("Application/images/la forge.jpg");
            }
            if(crew.get(index).getUrlImage().equals("Application/images/sulu.jpg")){
                crew.get(index).setUrlImage("Application/images/sulu.jpeg");
            }
            index++;}
        return crew;
    }


}
