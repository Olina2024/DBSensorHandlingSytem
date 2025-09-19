package com.example.thymeleafDemo.Controller;


import com.example.thymeleafDemo.Resposity.SensorRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @PostMapping("next")
    @ResponseBody
    public String next() {
        return "nu har du valt om du vill se 'senaste mätning' eller\n " +
                "'tidsintervall för historiska mätningar', \n " +
                "sidorna är fortfarande under uppbyggnad, tack för visad förståelse";
    }

}
