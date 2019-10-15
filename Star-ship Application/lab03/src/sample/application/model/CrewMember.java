package sample.application.model;
/*
This class will set and get the information from CreMemebers
- I will set  and get the name ,position,rank,species and registry
- I will also store this information inside an arrayList
 @pram   private String name;
 @pram   private String position;
 @pram   private String rank;
 @pram   private String species;
 @pram   private String registry;
 */
public class CrewMember {
    private String name;
    private String position;
    private String rank;
    private String species;
    private String registry;

    public void setName(String name) { this.name = name;}//set the name

    public String getName() { return name;} //Get the name

    public void setPosition(String position) {this.position = position;}// set the position

    public String getPosition() { return position; }// get the position

    public void setRank(String rank) { this.rank = rank;}// set the rank

    public String getRank() {return rank;}// get the rank

    public void setSpecies(String species) { this.species = species;}//set the species

    public String getSpecies() { return species; } //get the species

    public void setRegistry(String registry) { this.registry = registry;}//set the registry

    public String getRegistry() {return registry;} // set the registry


}
