package com.example.thymeleafDemo;

import com.example.thymeleafDemo.Model.Device;
import com.example.thymeleafDemo.Model.Sensor;
import com.example.thymeleafDemo.Resposity.DeviceRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ThymeleafDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafDemoApplication.class, args);}

   /* @Bean
    public CommandLineRunner createData(DeviceRepo repo, DeviceRepo deviceRepo) {
        return (args) -> {


            Device device = new Device("ESP_32,", null);
            //Friend friend1 = new Friend("karl", "karl@vän.se", "0706666666");

            deviceRepo.save(device);
            //repo.save(friend1);
        };*/
}

