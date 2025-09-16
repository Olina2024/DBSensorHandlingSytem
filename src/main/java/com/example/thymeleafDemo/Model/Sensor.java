package com.example.thymeleafDemo.Model;


public class Sensor {

    //protected int device_id;
    protected String type;
    protected float temperature;
    protected float humidity;

    public Sensor( String type,float temperature,float humidity ){


        this.temperature=temperature;
        this.type=type;
       this.humidity=humidity;



    }/*
    public int getDevice_id() {
        return device_id;
    }
    */
    public String getType(){
        return type;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getTemperature() {
        return temperature;
    }

}
