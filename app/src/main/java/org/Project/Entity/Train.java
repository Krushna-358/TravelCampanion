package org.Project.Entity;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Train {
    private String trainId;
    private String source;
    private String destination;
    private List<StationAndTime> stationAndTime = new ArrayList<>();

    public Train() {
    }
    private static final String PATH = "C:/users/user/Desktop/Projects/TravelCampanion/app/src/main/java/org/Project/LocalDB/Train.json";
    private static File trainJson = new File(PATH);
    static ObjectMapper objectMapper = new ObjectMapper();

    public Train(String trainId, String source, String destination, List<StationAndTime> stationAndTime) {
        this.trainId = trainId;
        this.source = source;
        this.destination = destination;
        this.stationAndTime = stationAndTime;
    }

    public String getTrainId() {
        return trainId;
    }

    public void setTrainId(String trainId) {
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

    public List<StationAndTime>  getStationAndTime() {
        return stationAndTime;
    }

    public void setStationAndTime(List<StationAndTime> stationAndTime) {
        this.stationAndTime = stationAndTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Train{");
        sb.append("\n");
        sb.append("trainId='").append(trainId).append('\'').append("\n");
        sb.append(", source='").append(source).append('\'').append("\n");
        sb.append(", destination='").append(destination).append('\'').append("\n");
        sb.append(", stationAndTime=").append(stationAndTime).append("\n");
        sb.append('}');
        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println("Path: " + trainJson.getAbsolutePath());
        System.out.println(trainJson.exists());

        List<Train> trainList = new ArrayList<>();

        try{
            trainList = objectMapper.readValue(trainJson, new TypeReference<List<Train>>() {
            });
            System.out.println("train load successfully");
        }catch (IOException e){
            e.getCause();
        }

        System.out.println(trainList.size());
        for (Train t : trainList){
            System.out.println(t);
            System.out.println();
        }
    }

}



