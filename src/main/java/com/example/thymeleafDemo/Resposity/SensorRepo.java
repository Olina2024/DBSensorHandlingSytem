package com.example.thymeleafDemo.Resposity;

import com.example.thymeleafDemo.Model.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorRepo extends JpaRepository<Sensor,Integer> {

}
