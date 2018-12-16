package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.*;
import com.dms.lab7.repository.*;
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
@RequestMapping("/constructor/state")
@RequiredArgsConstructor
public class StateController {

    private final StateRep stateRep;
    private final TypeProcessRep typeProcessRep;
    private final TypeStateRep typeStateRep;
    private final FunctRep functRep;

    @GetMapping
    public String get(Model model) {
        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("state", Util.get(stateRep));
        tables.put("typeProcess", Util.get(typeProcessRep));
        tables.put("typeState", Util.get(typeStateRep));
        tables.put("funct", Util.get(functRep));
        model.addAttribute("title", "Состояния");
        model.addAttribute("tables", tables);
        return "state";
    }

    @PostMapping
    public String post(Model model,
                       @RequestParam Long idProc,
                       @RequestParam Long idState,
                       @RequestParam Long idFunc,
                       @RequestParam Integer beg) {
        State state = new State();
        state.setTypeProcess(typeProcessRep.findById(idProc).orElseThrow(() -> new IllegalArgumentException("Нет такого типового процесса")));
        state.setTypeState(typeStateRep.findById(idState).orElseThrow(() -> new IllegalArgumentException("Нет такого типового состояния")));
        state.setFunct(functRep.findById(idFunc).orElseThrow(() -> new IllegalArgumentException("Нет такой функции")));
        state.setBegin(beg != 0);
        stateRep.save(state);
        return get(model);
    }
}

