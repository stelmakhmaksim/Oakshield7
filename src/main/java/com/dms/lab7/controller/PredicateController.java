package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.Predicat2;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.entity.TypeState;
import com.dms.lab7.repository.Predicate2Rep;
import com.dms.lab7.repository.TypeDecisionRep;
import com.dms.lab7.repository.TypeStateRep;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/predicate")
@RequiredArgsConstructor
public class PredicateController {

    private final TypeDecisionRep typeDecisionRep;
    private final TypeStateRep typeStateRep;
    private final Predicate2Rep predicate2Rep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(predicate2Rep);
        HashMap<String, List<List<String>>> tables = new HashMap<>();
        tables.put("predicat", collect);
        tables.put("dec", Util.get(typeDecisionRep));
        tables.put("state", Util.get(typeStateRep));
        model.addAttribute("title", "Предикаты");
        model.addAttribute("tables", tables);
        return "predicat";
    }

    @PostMapping
    public String post(Model model, @RequestParam Long decId, @RequestParam Long stateId) {
        Predicat2 prod = new Predicat2();
        TypeDecision dec = typeDecisionRep.findById(decId).orElseThrow(() -> new IllegalArgumentException("Нет такого решения"));
        TypeState state = typeStateRep.findById(stateId).orElseThrow(() -> new IllegalArgumentException("Нет такого состояния"));
        prod.setState(state);
        prod.setDecision(dec);
        predicate2Rep.save(prod);
        return get(model);
    }
}

