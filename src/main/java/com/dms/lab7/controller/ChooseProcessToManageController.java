package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.repository.TypeProcessRep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/choose_process")
@RequiredArgsConstructor
public class ChooseProcessToManageController {
    private final TypeProcessRep typeProcessRep;

    @GetMapping
    public String main(Model model) {
        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("typeProcess", Util.get(typeProcessRep));
        model.addAttribute("title", "Выбор процесса для управления");
        model.addAttribute("tables", tables);
        return "choose_process";
    }
}
