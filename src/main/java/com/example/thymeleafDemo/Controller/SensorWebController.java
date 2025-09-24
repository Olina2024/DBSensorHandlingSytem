package com.example.thymeleafDemo.Controller;

import com.example.thymeleafDemo.Model.Sensor;
import com.example.thymeleafDemo.Resposity.SensorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/web/sensor")
public class SensorWebController {

    private final SensorRepo repo;

    @GetMapping("/history")
    public String history(
            @RequestParam(value = "date", required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            Model model) {

        List<Sensor> data;

        if (date == null) {
            // inget datum skickat → hämta alla, sorterade senaste först
            data = repo.findAll(Sort.by(Sort.Direction.DESC, "creationDate"));
        } else {
            // ett specifikt datum skickat → hämta bara det dygnet
            LocalDateTime start = date.atStartOfDay();
            LocalDateTime end = date.plusDays(1).atStartOfDay().minusNanos(1);
            data = repo.findAllByCreationDateBetween(start, end);
            model.addAttribute("chosenDate", date);
        }

        model.addAttribute("sensors", data);
        return "history"; // matchar din history.html
    }
}
