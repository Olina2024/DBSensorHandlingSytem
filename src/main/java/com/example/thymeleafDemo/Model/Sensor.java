package com.example.thymeleafDemo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor


public class Sensor {
    @Id
    @GeneratedValue
    protected Long id;
    protected String sensor_type;
    protected float value;


    @ManyToOne
    @JoinColumn
    private Device device;


    public Sensor(String sensor_type, float value) {
        this.sensor_type = sensor_type;
        this.value = value;
    }


    public Sensor(String sensor_type, float value, Device device) {
        this.sensor_type = sensor_type;
        this.value = value;
        this.device = device;
    }
}
