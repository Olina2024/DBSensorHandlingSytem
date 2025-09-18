package com.example.thymeleafDemo.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="sensor")
@NoArgsConstructor
@AllArgsConstructor


public class Sensor {
    @Id
    @GeneratedValue
    protected Long id;
    protected float value;
    protected String sensor_type;

    public Sensor(String sensor_type, float value) {
        this.sensor_type = sensor_type;
        this.value = value;
    }
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "device_id")
    private Device device;

}
