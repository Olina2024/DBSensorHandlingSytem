package com.example.thymeleafDemo.Resposity;
import com.example.thymeleafDemo.Model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SensorDataRepo extends JpaRepository<SensorData, Long> {
}
