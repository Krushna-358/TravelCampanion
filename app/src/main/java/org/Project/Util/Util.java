package org.Project.Util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.Project.Entity.Train;
import org.Project.Entity.User;
import org.Project.Service.TicketServices;
import org.Project.Service.UserService;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.util.List;

import static org.Project.Entity.User.userJson;

public  class Util {

    public static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }


     static Train train = new Train();
     static UserService userService = new UserService();
     static TicketServices ticketServices = new TicketServices();



    public static String getUserName(String name) {
        StringBuilder uName = new StringBuilder();

        // Append first 4 characters of the name (or fewer if name is shorter)
        for (int i = 0; i < Math.min(4, name.length()); i++) {
            uName.append(name.charAt(i));
        }

        int num = (int)(Math.random() * 900) + 100;

        uName.append(num);

        return uName.toString();
    }


    public static   String generateHashPassword(String plainPassword){

        return BCrypt.hashpw(plainPassword ,BCrypt.gensalt(12));
    }

    public static   boolean checkPassword(String plainPassword , String hashPassword){
        return BCrypt.checkpw(plainPassword,hashPassword);
    }

    public static void loadUser(User updatedUser ){
//        try{
//            objectMapper.writeValue(userJson,userService.getUsers());//argument for write value (File , List)
//        } catch (IOException e) {
//            e.getCause();
//        }
        try {
            List<User> allUsers = objectMapper.readValue(userJson, new TypeReference<List<User>>() {});
            for (int i = 0; i < allUsers.size(); i++) {
                if (allUsers.get(i).getUserName().equals(updatedUser.getUserName())) {
                    allUsers.set(i, updatedUser);
                    break;
                }
            }
            objectMapper.writeValue(userJson, allUsers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValid(String trainId , String source , String destination){

        for (Train train : ticketServices.getTrainList()){

                if(!train.getTrainId().equals(trainId)){
                    continue;
                }
                else{

                    for(int j = 0; j < train.getStationAndTime().size() ; j++){

                        if(train.getStationAndTime().get(j).getStation().equals(source)){

                            for(int k = j ; k <train.getStationAndTime().size() ; k++ ){

                                if( train.getStationAndTime().get(k).getStation().equals(destination)){
                                    return true;
                                }
                            }
                        }
                    }

                    break;
                }

        }
        return false;
    }
}
