package com.example.thymeleafDemo.Controller;

import com.example.thymeleafDemo.Model.Device;
import com.example.thymeleafDemo.Model.Sensor;

import com.example.thymeleafDemo.Resposity.DeviceRepo;
//import com.example.thymeleafDemo.Resposity.SensorRepo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DBsensorController {
    Sensor sensor=null;
    Device device=null;
    List<Device> devices=new ArrayList<>();
    DeviceRepo deviceRepo;
    public DBsensorController(DeviceRepo deviceRepo){
        this.deviceRepo=deviceRepo;


    }

    @RequestMapping("/Dbsensor")

    public List<Device> databas() {

        return deviceRepo.findAll();

    }


    @RequestMapping("/Dbsensor/Senast")
    public Device senastDb() {

        return device;

    }



    @PostMapping("/Dbsensor/addNewData")
    public Device newData(@RequestBody Device device){

        deviceRepo.save(device);

        this.device=device;
        return device;

    }



}
