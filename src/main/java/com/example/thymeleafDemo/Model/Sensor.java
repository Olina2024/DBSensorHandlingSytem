package com.example.thymeleafDemo.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
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
    @JsonBackReference
    private Device device;


  @CreationTimestamp
    private LocalDateTime creationDate;
}
