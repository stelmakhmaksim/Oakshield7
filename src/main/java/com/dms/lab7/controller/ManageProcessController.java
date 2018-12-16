package com.dms.lab7.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/choose_process/{idProc}")
@RequiredArgsConstructor
public class ManageProcessController {
    @GetMapping
    public ModelAndView main(@RequestParam Long idProc) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("manage");
        return modelAndView;
    }
}
