package com.spring.controller;

import com.spring.enums.Gender;
import com.spring.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MentorController {

    @RequestMapping("/list")
    public String showTable(Model model){
        List<Mentor> mentors = new ArrayList<>();
        mentors.add(new Mentor("Mike","Smith",45,Gender.MALE));
        mentors.add(new Mentor("Tom","Hanks",65,Gender.MALE));
        mentors.add(new Mentor("Ammy","Bryan",25,Gender.FEMALE));

        model.addAttribute("mentors",mentors);

        return "/mentor/mentor-list";
    }
}
