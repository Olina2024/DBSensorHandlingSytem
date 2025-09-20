package com.example.thymeleafDemo.Model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "sensor_data")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float value;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sensor_id", nullable = false)
    private Sensor sensor;
}
