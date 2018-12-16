package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.Person;
import com.dms.lab7.repository.PersonRep;
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
@RequestMapping("/constructor/persons")
@RequiredArgsConstructor
public class PersonController {

    private final PersonRep personRep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(personRep);
        model.addAttribute("title", "Сотрудники");
        Map<String, List<List<String>>> res = Collections.singletonMap("persons", collect);
        model.addAttribute("tables", res);
        return "person";
    }

    @PostMapping
    public String post(Model model, @RequestParam String name) {
        Person prod = new Person();
        prod.setFio(name);
        personRep.save(prod);
        return get(model);
    }
}

