package org.Project.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.Project.Entity.StationAndTime;
import org.Project.Entity.Ticket;
import org.Project.Entity.Train;
import org.Project.Entity.User;
import org.Project.Util.Util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.Project.Entity.User.userJson;

public class TicketServices {

    public  List<Train> getTrainList() {
        return trainList;
    }

    public  void setTrainList(List<Train> trainList) {
        TicketServices.trainList = trainList;
    }

    static User user;
    Ticket ticket;
    static Train train = new Train();
    static ObjectMapper objectMapper = new ObjectMapper();
    private static final String PATH = "C:/Users/user/Desktop/Projects/TravelCampanion/app/src/main/java/org/Project/LocalDB/Train.json";
    static File trainJson = new File(PATH);
    static List<Train> trainList = new ArrayList<>();
    UserService userService = new UserService();
    public TicketServices() {
        try{
            trainList = objectMapper.readValue(trainJson, new TypeReference<List<Train>>() {
            });
        }catch (
                IOException e){
            e.getCause();
        }
    }

    public  List searchTrain(String source , String destination){//implement using stream
        List<Train>  matchedTrain = new ArrayList<>();
        System.out.println("in methode search train");
        Train t1 = new Train();
        StationAndTime sandt = new StationAndTime();
        for(int i = 0 ; i < trainList.size() ; i++){
            t1 = trainList.get(i);
            for(int j = 0; j < t1.getStationAndTime().size() ; j++){
                sandt = t1.getStationAndTime().get(j);
//                        String x = sandt.getStation();
                if(sandt.getStation().equals(source)){
                    for(int k = j ; k <t1.getStationAndTime().size() ; k++ ){
//                                sandt = t1.getStationAndTime().get(k);
//                                String y = sandt.getStation();
                        if( t1.getStationAndTime().get(k).getStation().equals(destination)){
                            matchedTrain.add(t1);
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("Total train available : " +matchedTrain.size());
        return matchedTrain;
    }

    public void bookTicket(User user, String source, String destination, String dateOfTravel, String trainId ){

        if(Util.isValid(trainId,source,destination)){
            Ticket ticket = new Ticket(String.valueOf(Math.round(Math.random()*(9999 - 1000 +1)+100)),trainId,
                    source,destination,user.getUserName(),dateOfTravel);
            System.out.println(ticket);
            boolean result = user.getBookedTickets().add(ticket);
            Util.loadUser(user);//adds new ticket to booked ticket list
            System.out.println("ticket booked successfully");
        }else{
            System.out.printf("Unable to book Ticket \n " +
                                "Enter valid info\n" +
                                "Check trainid : %S ,source : %s , destination : %s",trainId,source,destination);
        }


    }

    public void fetchTickets(String userName){

        Optional<User> user = userService.getUsers().stream().filter(u -> userName.equals(u.getUserName())).findFirst();

        List<Ticket> tickets = user.get().getBookedTickets();
        if(!tickets.isEmpty()){
            for (Ticket t : tickets){
                System.out.println(t+"\n");
            }
        }else {
            System.out.println("You haven`t booked any ticket yet ");
        }

    }



    public void cancelTicket(User user ,String ticketId){
        Optional<Ticket> ticket1 =  user.getBookedTickets().stream().filter(t1 -> ticketId.equals(t1.getTicketId())).findFirst();
        if(ticket1.isPresent()){
            ticket = ticket1.get();
            user.getBookedTickets().remove(ticket);
            Util.loadUser(user);
            System.out.println("ticket cancelled successfully");
        }else {
            System.out.println("Ticket with ticketID \""+ticketId+"\" is not found !");
        }

    }
}
