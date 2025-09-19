package com.example.thymeleafDemo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue
    protected  Long id;
    protected  String device_type;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)

    private List<Sensor> sensors;

    public Device(String device_type, List<Sensor> sensors)
    {
        for (Sensor sensor : sensors)
            System.out.println(sensor.getSensor_type()+sensor.getValue());

        this.sensors=sensors;
        this.device_type=device_type;
    }

    public Device (String device_type){
        this.device_type=device_type;
    }


}
