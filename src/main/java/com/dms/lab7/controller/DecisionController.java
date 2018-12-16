package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.Decision;
import com.dms.lab7.repository.DecisionRep;
import com.dms.lab7.repository.StateRep;
import com.dms.lab7.repository.TypeDecisionRep;
import com.dms.lab7.repository.TypeProcessRep;
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
@RequestMapping("/constructor/dec")
@RequiredArgsConstructor
public class DecisionController {

    private final DecisionRep decisionRep;
    private final TypeProcessRep typeProcessRep;
    private final StateRep stateRep;
    private final TypeDecisionRep typeDecisionRep;

    @GetMapping
    public String get(Model model) {
        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("decisions", Util.get(decisionRep));
        tables.put("typeProcess", Util.get(typeProcessRep));
        tables.put("typeState", Util.get(stateRep));
        tables.put("typeDecision", Util.get(typeDecisionRep));
        model.addAttribute("title", "Решения");
        model.addAttribute("tables", tables);
        return "decision";
    }

    @PostMapping
    public String post(Model model,
                       @RequestParam Long idProc,
                       @RequestParam Long idState,
                       @RequestParam Long idDec) {
        Decision decision = new Decision();
        decision.setTypeProcess(typeProcessRep.findById(idProc).orElseThrow(() -> new IllegalArgumentException("Нет такого типового процесса")));
        decision.setState(stateRep.findById(idState).orElseThrow(() -> new IllegalArgumentException("Нет такого состояния")));
        decision.setTypeDecision(typeDecisionRep.findById(idDec).orElseThrow(() -> new IllegalArgumentException("Нет такого типового решения")));
        decisionRep.save(decision);
        return get(model);
    }
}

