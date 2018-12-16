package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.GrPerson;
import com.dms.lab7.entity.Person;
import com.dms.lab7.repository.GrPersonRep;
import com.dms.lab7.repository.PersonRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/grIncl")
@RequiredArgsConstructor
public class GrInclController {

    private final GrPersonRep grPersonRep;
    private final PersonRep personRep;

    @GetMapping
    public String get(Model model) {
        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("persons", Util.get(personRep));
        tables.put("grPersons", Util.get(grPersonRep));
        model.addAttribute("title", "Включение в группу");
        model.addAttribute("tables", tables);
        return "grincl";
    }

    @PostMapping
    public String post(Model model,
                       @RequestParam Long id,
                       @RequestParam Long personId) {
        GrPerson gr = grPersonRep.findById(id).orElseThrow(() -> new IllegalArgumentException("Нет такой группы"));
        Person per = personRep.findById(personId).orElseThrow(() -> new IllegalArgumentException("Нет такого сотрудника"));
        gr.getPersons().add(per);
        grPersonRep.save(gr);
        return get(model);
    }
}

