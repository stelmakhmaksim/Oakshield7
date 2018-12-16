package com.dms.lab7.controller;

import com.dms.lab7.entity.Predicat2;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.entity.TypeState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/choose_process")
public class ChooseProcessToManageController {

    @GetMapping
    public String main() {
        return "choose_process";
    }

    @PostMapping
    public String post(Model model, @RequestParam Long decId, @RequestParam Long stateId) {
        return "manage_process";
    }
}
