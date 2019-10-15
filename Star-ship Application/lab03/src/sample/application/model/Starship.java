package sample.application.model;

import java.util.ArrayList;
/*
This class will set and get the information from startShip
- It will set and get the name, registry and the starshipClass
- There is also going to be Array list that have the starshipClass information
- this class will set and get the information from that arrayLisit
 */
public class Starship {

    private String name;
    private String registry;
    private String starshipClass;
    ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}
    public void setRegistry(String registry) {this.registry = registry;}
    public String getRegistry() {return registry;}
    public String getStarshipClass() {return starshipClass;}
    public void setStarshipClass(String starshipClass) {this.starshipClass = starshipClass;}
    public void setCrewMembers(ArrayList<CrewMember> crewMembers) {this.crewMembers = crewMembers;}
    public ArrayList<CrewMember> getCrewMembers() {return crewMembers;}
}
