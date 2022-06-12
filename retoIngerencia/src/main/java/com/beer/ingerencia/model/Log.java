package com.beer.ingerencia.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.sql.Timestamp;

@Entity
public class Log {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "service_name")
    private String service_name;

    @Column(name = "execution_hour")
    private Timestamp execution_hour;

    @Column(name = "response_time")
    private String response_time;

    public Log() {
    }

    public Log(Long id, String service_name, Timestamp execution_hour, String response_time) {
        this.id = id;
        this.service_name = service_name;
        this.execution_hour = execution_hour;
        this.response_time = response_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Timestamp getExecution_hour() {
        return execution_hour;
    }

    public void setExecution_hour(Timestamp execution_hour) {
        this.execution_hour = execution_hour;
    }

    public String getResponse_time() {
        return response_time;
    }

    public void setResponse_time(String response_time) {
        this.response_time = response_time;
    }
}
