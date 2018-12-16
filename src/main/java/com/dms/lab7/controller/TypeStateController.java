package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.TypeState;
import com.dms.lab7.repository.TypeStateRep;
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
@RequestMapping("/constructor/typeState")
@RequiredArgsConstructor
public class TypeStateController {

    private final TypeStateRep typeStateRep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(typeStateRep);
        model.addAttribute("title", "Типы состояний");
        Map<String, List<List<String>>> res = Collections.singletonMap("typeState", collect);
        model.addAttribute("tables", res);
        return "typeState";
    }

    @PostMapping
    public String post(Model model, @RequestParam String name) {
        TypeState dec = new TypeState();
        dec.setName(name);
        typeStateRep.save(dec);
        return get(model);
    }
}

