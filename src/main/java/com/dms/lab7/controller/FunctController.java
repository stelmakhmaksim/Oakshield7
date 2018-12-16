package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.Funct;
import com.dms.lab7.repository.FunctRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/funct")
@RequiredArgsConstructor
public class FunctController {

    private final FunctRep functRep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(functRep);
        model.addAttribute("title", "Функции");
        Map<String, List<List<String>>> res = Collections.singletonMap("funct", collect);
        model.addAttribute("tables", res);
        return "funct";
    }

    @PostMapping
    public String post(Model model, @RequestParam String name) {
        Funct prod = new Funct();
        prod.setName(name);
        functRep.save(prod);
        return get(model);
    }
}

