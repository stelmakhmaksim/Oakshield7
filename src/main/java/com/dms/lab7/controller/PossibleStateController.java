package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.PossibleState;
import com.dms.lab7.entity.Predicat2;
import com.dms.lab7.entity.TypeProcess;
import com.dms.lab7.repository.PossibleStateRep;
import com.dms.lab7.repository.Predicate2Rep;
import com.dms.lab7.repository.TypeProcessRep;
import com.dms.lab7.repository.TypeStateRep;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/constructor/possibleState")
@RequiredArgsConstructor
public class PossibleStateController {

    private final PossibleStateRep possibleStateRep;
    private final TypeProcessRep typeProcessRep;
    private final Predicate2Rep predicat2Rep;
    private final TypeStateRep typeStateRep;

    @GetMapping
    public String get(Model model) {
        if (possibleStateRep.findAll().size() == 0) {
            List<Predicat2> predicates = predicat2Rep.findAll();

            for (Predicat2 predicate : predicates) {
                PossibleState possibleState = new PossibleState();
                possibleState.setPredicat2(predicate);
                possibleState.setTypeState(typeStateRep.findAll().get(0));
                possibleStateRep.save(possibleState);
            }
        }

        List<List<String>> collect = Util.get(predicat2Rep);
        HashMap<String, List<List<String>>> tables = new HashMap<>();
        tables.put("predicat", collect);
        tables.put("typeState", Util.get(typeStateRep));
        tables.put("possibleState", Util.get(possibleStateRep));
        model.addAttribute("title", "Возможные состояния переходов");
        model.addAttribute("tables", tables);
        return "possibleState";
    }

    @PostMapping
    public String post(Model model, @RequestParam Long idProcess,
        @RequestParam Long idPossibleState,
        @RequestParam Long idState) {
        TypeProcess typeProcess = typeProcessRep.getOne(idProcess);
        PossibleState possibleState = possibleStateRep.getOne(idPossibleState);
        possibleState.setTypeProcess(typeProcess);
        possibleState.setTypeState(typeStateRep.findById(idState)
            .orElseThrow(() -> new IllegalArgumentException("Нет такого типового состояния")));
        possibleStateRep.save(possibleState);
        return get(model);
    }
}
