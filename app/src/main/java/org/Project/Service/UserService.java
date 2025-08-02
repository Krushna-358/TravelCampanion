package org.Project.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.Project.Entity.User;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.Project.Util.Util.*;

public class UserService {
//    public static void main(String[] args) {
//        UserService userService = new UserService();
//        int i = 1;
//
//        for(User user : userService.getUsers() ){
//            i++;
//        }
//        System.out.println(i);
//    }

    private List<User> users = new ArrayList<>();

    final private static String PATH = "C:/Users/user/Desktop/Projects/TravelCampanion/app/src/main/java/org/Project/LocalDB/User.json";

    final  static File userJson = new File(PATH);

//    ObjectMapper objectMapper;

    public UserService() {

        try{
            users = objectMapper.readValue(userJson, new TypeReference<>() {
            });
        } catch (IOException e) {
            e.getCause();
        }

        {
            // This will ensure pretty (indented) JSON output
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


//Sign for new user
    public  void userSignIn(String name , String password){
        try {
            // Step 1: Load existing users from file
//            List<User> existingUsers = new ArrayList<>();
            if (userJson.exists()) {
                users = objectMapper.readValue(userJson, new TypeReference<List<User>>() {});
            }

            // Step 2: Create new user
            String username = getUserName(name);
            User user = new User(name, generateHashPassword(password), username, new ArrayList<>());

            // Step 3: Add new user to existing list
            users.add(user);

            // Step 4: Save updated user list
            objectMapper.writeValue(userJson, users);

            System.out.println("User added successfully");
            System.out.println("Your username is: " + user.getUserName());

        } catch (IOException e) {
            e.printStackTrace(); // Better than e.getCause()
        }
//        String username = getUserName(name);
//        User user = new User(name,generateHashPassword(password),username,new ArrayList<>());
//        users.add(user);
//        Util.loadUser(user);
//        try{
//            objectMapper.writeValue(userJson, users);//argument for write value (File , List)
//            System.out.println("User added successfully");
//            System.out.println("Your username is : "+user.getUserName());
//            //  return true;
//        } catch (IOException e) {
//                e.getCause();
//        }
        //return false;
    }

    //log in for existing user
    public  User userLogin(String user_name ,String pass_word){

        Optional<User> user = users.stream().filter(user1 -> user1.getUserName().equals(user_name) && checkPassword(pass_word,user1.getPassword()) ).findFirst();
         User u ;
         if (user.isPresent()) {
             u = user.get();
             System.out.println("\"Logged in Successfully\"");
         }else {
             System.out.println("\"Inavlid Credentials\"");
             return null;
         }

         return u;
    }


    //password change
    public void changePassword(){

    }

}
