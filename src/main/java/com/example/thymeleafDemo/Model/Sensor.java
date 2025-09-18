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

/*
public class Sensor {
    @Id
    @GeneratedValue
    protected Long id;
    protected List<Sensor_type> sensor_types;
    protected float value;
    Sensor_type sensor_type;

    public Sensor( Device device,List<Sensor_type> sensor_types,Sensor_type sensor_type,float value){



        this.sensor_type=sensor_types.get(0);

        this.value=value;



    }
    public int getDevice_id() {
        return device_id;
    }
  
    public String device_type(){
        return device_type;
    }

   public String sensor_type(){
        return sensor_type;
   }
   public Float value(){

       return value;

   }
   @OneToOne
   @JoinColumn
    private Device device;
    
 */

}
        