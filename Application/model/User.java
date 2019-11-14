package Application.model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class User {
    ArrayList<User> users = new ArrayList<User>();
    String UserName;
    String Paassword;
    String CurUser;

    /**
     * @params UserName
     * @params Password
     * @params CurUser
     *
     */

    /**
     * @return Username
     */
    public String getUserName() {return UserName;}

    /**
     * @params Username
     */
    public void setUserName(String userName) {UserName = userName;}

    /**
     * @return Password
     */

    public String getPaassword() {return Paassword;}

    /**
     * @param paassword
     */

    public void setPaassword(String paassword) {Paassword = paassword;}

    /**
     * @return Curuser
     */

    public String getCurUser() {return CurUser;}

    /**
     * @param curUser
     */

    public void setCurUser(String curUser) {CurUser = curUser;}


    /*
    This function will read in the information from users
     */
    public void ReadInUsers() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File
                ("src/Application/data/users.csv"));
        scanner.useDelimiter(Pattern.compile("[\n|,]"));
        int index = 0;
        while (scanner.hasNext()){
            users.add(new User());
            users.get(index).setUserName(scanner.next());
            users.get(index).setPaassword(scanner.next());
            index++;
        }
    }

    /*

     validate which should take in a user name and password. This method should be called from the controller.
     */

    public boolean validate(String username, String password) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(username) && users.get(i).getPaassword().equals(password)) {
                return true;}}
        return false;}

}








