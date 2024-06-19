package com.example.application.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 'expomos'  o caminho "/"
@RestController
public class FirstRestController {

    // injetams as dependencias coach.name e team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String coachTeam;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + coachTeam;
    }

    @GetMapping("/")
    public String sayHellow() {
        return "Hello word";
    }
}