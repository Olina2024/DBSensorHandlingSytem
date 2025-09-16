package com.example.thymeleafDemo.Controller;

import com.example.thymeleafDemo.Model.Sensor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DBsensorController {
    Sensor sensor=null;
    List<Sensor> sensors=new ArrayList<>();
    @RequestMapping("/Dbsensor")
    public List<Sensor> databas() {

        return sensors;

    }

    @RequestMapping("/Dbsensor/Senast")
    public Sensor senastDb() {

        return sensor;

    }

    @PostMapping("/Dbsensor/addNewData")
    public List<Sensor> newData(@RequestBody Sensor sensor){
       // System.out.println("sensor:"+sensor.getDevice_id());
/*
        System.out.println("type:"+sensor.getType());
        System.out.println("humidity:"+sensor.getHumidity());
        System.out.println("temperature:"+sensor.getTemperature());

 */
        sensors.add(sensor);
        this.sensor=sensor;
        return sensors;

    }






}
