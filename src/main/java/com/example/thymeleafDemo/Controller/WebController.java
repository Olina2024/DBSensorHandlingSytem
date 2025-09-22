package com.example.thymeleafDemo.Controller;

import com.example.thymeleafDemo.Model.Sensor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Controller  //tells spring: this class handles web pages.
public class WebController {

    @GetMapping("/")   //when someone visits the homepage...
    public String SensorDataCollection (Model model){ // Model = container to put data in

        RestTemplate restTemplate = new RestTemplate(); // tool to call APIs

        try {
            //latest sensor reading
            Sensor latesSensor = restTemplate.getForObject("http://localhost:8080/DBsensor/Senast", Sensor.class);
            model.addAttribute("latestSensor", latesSensor);

            //get all sensor readings
            ResponseEntity<List<Sensor>> response = restTemplate.exchange(
                    "http://localhost:8080/Dbsensor",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Sensor>>() {}
            );
            List<Sensor> allSensors = response.getBody();
            model.addAttribute("allSensors", allSensors);
            model.addAttribute("totalReadings", allSensors != null ? allSensors.size() : 0);
        } catch (Exception e) {
            //troubleshooting
            System.out.println("No sensor data available: " + e.getMessage());
            model.addAttribute("latestSensor", null);
            model.addAttribute("allSensors", null);
            model.addAttribute("totalReadings", 0);

        }
        return "SensorDataCollection"; // ...show them the dashboard.html page.
    }
}


