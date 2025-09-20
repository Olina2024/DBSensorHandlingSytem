package com.example.thymeleafDemo.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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


    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Sensor> sensors;


}
