package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.Formula;
import com.dms.lab7.repository.FormulaRep;
import com.dms.lab7.repository.FunctRep;
import com.dms.lab7.repository.Predicate2Rep;
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
@RequestMapping("/constructor/formula")
@RequiredArgsConstructor
public class FormulaController {

    private final FormulaRep formulaRep;
    private final FunctRep functRep;
    private final Predicate2Rep predicate2Rep;

    @GetMapping
    public String get(Model model) {
        HashMap<String, List<List<String>>> tables = new HashMap<>();
        tables.put("formula", Util.get(formulaRep));
        tables.put("pred", Util.get(predicate2Rep));
        tables.put("funct", Util.get(functRep));
        model.addAttribute("title", "Формулы");
        model.addAttribute("tables", tables);
        return "formula";
    }

    @PostMapping
    public String post(Model model,
                       @RequestParam Long funcId,
                       @RequestParam Integer conNum,
                       @RequestParam Integer disNum,
                       @RequestParam Long predId) {
        Formula formula = new Formula();
        formula.setFunct(functRep.findById(funcId).orElseThrow(() -> new IllegalArgumentException("Нет такой функции")));
        formula.setCon(conNum);
        formula.setDis(disNum);
        formula.setPredicat2(predicate2Rep.findById(predId).orElseThrow(() -> new IllegalArgumentException("Нет такого предиката")));
        formulaRep.save(formula);
        return get(model);
    }
}

