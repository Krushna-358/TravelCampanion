package org.Project.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public  class  StationAndTime {
    private String station;
    @JsonProperty("Time") // 👈 This tells Jackson to use "Time" from JSO
    private String time;

    public StationAndTime() {
    }

    public StationAndTime(String station, String time) {
        this.station = station;
        time = time;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String gettime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StationAndTime{");
        sb.append("\n");
        sb.append("station='").append(station).append('\'').append("\n");
        sb.append(", Time='").append(time).append('\'').append("\n");
        sb.append('}');
        return sb.toString();
    }
}
