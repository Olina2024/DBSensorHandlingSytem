package com.example.thymeleafDemo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Device",uniqueConstraints = @UniqueConstraint(columnNames = "device_type"))
@NoArgsConstructor
@AllArgsConstructor
public class Device {
    @Id
    @GeneratedValue
    protected  Long id;
    @Column(nullable = false)
    protected  String device_type;


    @CreationTimestamp
    protected Date created;

    @UpdateTimestamp
    protected Date updated;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    @JsonManagedReference
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
