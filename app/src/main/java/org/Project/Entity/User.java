package org.Project.Entity;

//import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.mindrot.jbcrypt.BCrypt;

import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;
//import java.util.Optional;
import java.util.Scanner;

public class User {
    private String name ;
    private String password;
    private String userName;
    private List<Ticket> bookedTickets;

    static BCrypt bCrypt = new BCrypt();

//    static List<User> users = new ArrayList<>();

    static  Scanner scanner = new Scanner(System.in);

    final private static String PATH = "C:/Users/user/Desktop/Projects/TravelCampanion/app/src/main/java/org/Project/LocalDB/User.json";
    public final static File userJson = new File(PATH);
    static  ObjectMapper objectMapper = new ObjectMapper();

    public User(String name, String password, String userName, List<Ticket> bookedTickets) {
        this.name = name;
        this.password = password;
        this.userName = userName;
        this.bookedTickets = bookedTickets;
    }

    public User(String name, String password, String userName) {
        this.name = name;
        this.password = password;
        this.userName = userName;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    public void setBookedTickets(List<Ticket> bookedTickets) {
        this.bookedTickets = bookedTickets;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("name='").append(name).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", bookedTickets=").append(bookedTickets);
        sb.append('}');
        return sb.toString();
    }

//    public static void main(String[] args) {
//
//
//
//        try{
//            users = objectMapper.readValue(userJson, new TypeReference<List<User>>() {
//            });
//        } catch (IOException e) {
//            e.getCause();
//        }
//        System.out.println("File exists: " + userJson.exists());
//
//       for(User user : users){
//           System.out.println(user);
//           System.out.println();
//       }
//
//        System.out.println("Enter your username ");
//        String name = scanner.nextLine();
//        System.out.println("Set your password");
//        String password = scanner.nextLine();
//
//        System.out.println("Sign in");
//        userSignIn(name , password);
//
//        System.out.println("log in");
//        System.out.println("Enter your username ");
//        String name1 = scanner.nextLine();
//        System.out.println("Enter your password");
//        String password1 = scanner.nextLine();
//        System.out.println(userLogin(name1,password1));
//
//    }
//
//    public static void userSignIn(String name , String password){
//        String username = getUserName(name);
//        User user = new User(name,generateHashPassword(password),username);
//        users.add(user);
//        try{
//            objectMapper.writeValue(userJson, users);//argument for write value (File , List)
//            System.out.println("User added successfully");
//            System.out.println("Your username is : "+user.getUserName());
//          //  return true;
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        //return false;
//    }
//
//    public static String userLogin(String userName1 ,String password){
//
//        String username = userName1;
//        String pass = password;
//
//        Optional<User> userForLogIn = users.stream().filter(user1 -> user1.getUserName().equals(username) && checkPassword(password,user1.getPassword()) ).findFirst();
//
//        return userForLogIn.isPresent() ? "Logged in Successfully" : "Inavlid Credentials";
//    }
//
//    public static String getUserName(String name){
//        String uName = "";
//        String randNum = "";
//        for(int i = 0 ; i < 4 ; i++){
//            uName += name.charAt(i);
//        }
//        for (int i = 1 ;  i < 5 ; i++){
//            int num = (int)(Math.random() * (999 - 100 + 1)) + 100;
//            randNum = String.valueOf(num);
//        }
//        return uName + randNum;
//    }
//
//    public static  String generateHashPassword(String plainPassword){
//
//        return bCrypt.hashpw(plainPassword ,bCrypt.gensalt(12));
//    }
//
//    public static boolean checkPassword(String plainPassword , String hashPassword){
//        return bCrypt.checkpw(plainPassword,hashPassword);
//    }
}
