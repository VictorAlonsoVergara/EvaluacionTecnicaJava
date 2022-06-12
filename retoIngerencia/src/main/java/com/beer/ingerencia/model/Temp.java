package com.beer.ingerencia.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Temp {
    private Data temp;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double duration;

    public Temp() {
    }

    public Temp(Data temp, Double duration) {
        this.temp = temp;
        this.duration = duration;
    }

    public Data getTemp() {
        return temp;
    }

    public void setTemp(Data temp) {
        this.temp = temp;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }
}
