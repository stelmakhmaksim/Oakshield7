package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.AccessState;
import com.dms.lab7.repository.AccessStateRep;
import com.dms.lab7.repository.GrPersonRep;
import com.dms.lab7.repository.StateRep;
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
@RequestMapping("/constructor/perm")
@RequiredArgsConstructor
public class AccessController {

    private final AccessStateRep accessStateRep;
    private final TypeProcessRep typeProcessRep;
    private final StateRep stateRep;
    private final GrPersonRep grPersonRep;

    @GetMapping
    public String get(Model model) {
        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("access", Util.get(accessStateRep));
        tables.put("typeProcess", Util.get(typeProcessRep));
        tables.put("state", Util.get(stateRep));
        tables.put("grPerson", Util.get(grPersonRep));
        model.addAttribute("title", "Разрешения");
        model.addAttribute("tables", tables);
        return "access";
    }

    @PostMapping
    public String post(Model model,
                       @RequestParam Long idProc,
                       @RequestParam Long idState,
                       @RequestParam Long idGr) {
        AccessState accessState = new AccessState();
        accessState.setTypeProcess(typeProcessRep.findById(idProc).orElseThrow(() -> new IllegalArgumentException("Нет такого типового процесса")));
        accessState.setState(stateRep.findById(idState).orElseThrow(() -> new IllegalArgumentException("Нет такого состояния")));
        accessState.setGrPerson(grPersonRep.findById(idGr).orElseThrow(() -> new IllegalArgumentException("Нет такой группы")));
        accessStateRep.save(accessState);
        return get(model);
    }
}

