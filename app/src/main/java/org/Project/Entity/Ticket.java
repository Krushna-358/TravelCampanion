package org.Project.Entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
import java.util.Optional;


public class Ticket {
    private final String ticketId;
    private String trainId;
    private String source;
    private String destination;
    private String passengerName;
    private String dateOfTravel;

    static User user;
    static Train train;
    static ObjectMapper objectMapper;
    private static final String PATH = "C:/Users/user/Desktop/Projects/TravelCampanion/app/src/main/java/org/Project/LocalDB/Train.json";
    static File trainJson = new File(PATH);
    static List<Train> trainList = new ArrayList<>();

    public Ticket(String ticketId,String trainId, String source, String destination, String passengerName, String dateOfTravel) {
        this.ticketId = ticketId;
        this.trainId = trainId;
        this.source = source;
        this.destination = destination;
        this.passengerName = passengerName;
        this.dateOfTravel = dateOfTravel;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.trainId = trainId;
    }

    public String getTrainId() {
        return ticketId;
    }

    public void setTrainId(String ticketId) {
        this.trainId = trainId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDateOfTravel() {
        return dateOfTravel;
    }

    public void setDateOfTravel(String dateOfTravel) {
        this.dateOfTravel = dateOfTravel;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ticket{");
        sb.append("ticketId='").append(ticketId).append('\'');
        sb.append(", trainId='").append(trainId).append('\'');
        sb.append(", source='").append(source).append('\'');
        sb.append(", destination='").append(destination).append('\'');
        sb.append(", passengerName='").append(passengerName).append('\'');
        sb.append(", dateOfTravel='").append(dateOfTravel).append('\'');
        sb.append('}');
        return sb.toString();
    }

//    public static void main(String[] args) {
//        train = new Train();
//        objectMapper = new ObjectMapper();
//        System.out.println(trainJson.exists());
//
//        try{
//             trainList = objectMapper.readValue(trainJson, new TypeReference<List<Train>>() {
//            });
//        }catch (IOException e){
//            e.getCause();
//        }
////        for (Train t : trainList){
////            System.out.println(t);
////            System.out.println();
////        }
//
//        System.out.println(searchTrain("Nagpur","Ballarshah"));    }
//
//    public static List searchTrain(String source , String destination){//implement using stream
//        List<Train>  matchedTrain = new ArrayList<>();
//        System.out.println("in methode search train");
//        Train t1 = new Train();
//        StationAndTime sandt = new StationAndTime();
//        for(int i = 0 ; i < trainList.size() ; i++){
//            t1 = trainList.get(i);
//                    for(int j = 0; j < t1.getStationAndTime().size() ; j++){
//                        sandt = t1.getStationAndTime().get(j);
////                        String x = sandt.getStation();
//                        if(sandt.getStation().equals(source)){
//                            for(int k = j ; k <t1.getStationAndTime().size() ; k++ ){
////                                sandt = t1.getStationAndTime().get(k);
////                                String y = sandt.getStation();
//                            if( t1.getStationAndTime().get(k).getStation().equals(destination)){
//                                matchedTrain.add(t1);
//                              break;
//                            }
//                            }
//                        }
//                    }
//        }
//
//        System.out.println("Total train available : " +matchedTrain.size());
//        return matchedTrain;
//    }
//
//    public Ticket bookTicket(User user,String source,String destination,String dateOfTravel,String trainId ){
//        return new Ticket(String.valueOf(Math.random()*(9999 - 1000 +1)+100),trainId,source,destination,user.getUserName(),dateOfTravel);
//    }
//
//    public List fetchTickets(String userName){
//
//        Optional<User> user = users.stream().filter(u -> userName.equals(u.getUserName())).findFirst();
//
//        return user.get().getBookedTickets();
//    }
//
//
//
//    public void cancelTicket(User user ,String ticketId){
//        Optional<Ticket> ticket =  user.getBookedTickets().stream().filter(t1 -> ticketId.equals(t1.getTicketId())).findFirst();
//        user.getBookedTickets().remove(ticket);
//    }
//

}//class end
