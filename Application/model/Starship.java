package Application.model;

import java.util.ArrayList;

public class Starship {
        private String name;
        private String registry;
        private String starshipClass;
        public ArrayList<CrewMember> crewMembers = new ArrayList<CrewMember>();

        public void setName(String name) {this.name = name;}
        public String getName() {return name;}
        public void setRegistry(String registry) {this.registry = registry;}
        public String getRegistry() {return registry;}
        public String getStarshipClass() {return starshipClass;}
        public void setStarshipClass(String starshipClass) {this.starshipClass = starshipClass;}
        public void setCrewMembers(ArrayList<CrewMember> crewMembers) {this.crewMembers = crewMembers;}
        public ArrayList<CrewMember> getCrewMembers() {return crewMembers;}
    }

