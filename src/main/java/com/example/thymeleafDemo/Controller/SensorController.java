package com.example.thymeleafDemo.Controller;


import com.example.thymeleafDemo.Model.Device;
import com.example.thymeleafDemo.Resposity.SensorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller

public class SensorController {

    private SensorRepo sensorRepo;

    private SensorController(SensorRepo sensorRepo) {this.sensorRepo = sensorRepo;}

    @RequestMapping("StartHere")
    public String StartHere() {
        return "start.html";
    }

    // välj mellan senaste och historiska mätningar
    @PostMapping("showDevice")
    public String pageTwo() {
        return "optionpage.html";
    }

    // senaste mätningen
    @PostMapping("next")
    @ResponseBody
    public String next(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        Device latestDevice = restTemplate.getForObject("http://localhost:8080/Dbsensor/Senast", Device.class);
        model.addAttribute("latestDevice", latestDevice);
        return "latestReading";
    }

    @PostMapping("oldreadings")
    @ResponseBody
    public String oldstuff() {
        return "gamla mätningar";
    }


}
