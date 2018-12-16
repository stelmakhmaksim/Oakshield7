package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.GrPerson;
import com.dms.lab7.repository.GrPersonRep;
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
@RequestMapping("/grPersons")
@RequiredArgsConstructor
public class GrPersonController {

    private final GrPersonRep grPersonRep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(grPersonRep);
        model.addAttribute("title", "Группы");
        Map<String, List<List<String>>> res = Collections.singletonMap("grPerson", collect);
        model.addAttribute("tables", res);
        return "grperson";
    }

    @PostMapping
    public String post(Model model, @RequestParam String name) {
        GrPerson prod = new GrPerson();
        prod.setName(name);
        grPersonRep.save(prod);
        return get(model);
    }
}

