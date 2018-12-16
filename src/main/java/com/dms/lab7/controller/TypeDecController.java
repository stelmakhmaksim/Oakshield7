package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.repository.TypeDecisionRep;
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
@RequestMapping("/constructor/typeDec")
@RequiredArgsConstructor
public class TypeDecController {

    private final TypeDecisionRep typeDecisionRep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(typeDecisionRep);
        model.addAttribute("title", "Типы решений");
        Map<String, List<List<String>>> res = Collections.singletonMap("typeDec", collect);
        model.addAttribute("tables", res);
        return "typeDec";
    }

    @PostMapping
    public String post(Model model, @RequestParam String name) {
        TypeDecision dec = new TypeDecision();
        dec.setName(name);
        typeDecisionRep.save(dec);
        return get(model);
    }
}

