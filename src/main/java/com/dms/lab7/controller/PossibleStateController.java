package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.PossibleState;
import com.dms.lab7.entity.Predicat2;
import com.dms.lab7.repository.PossibleStateRep;
import com.dms.lab7.repository.Predicate2Rep;
import com.dms.lab7.repository.TypeStateRep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/constructor/possibleState")
@RequiredArgsConstructor
public class PossibleStateController {

    private final PossibleStateRep possibleStateRep;
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

        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("typeState", Util.get(typeStateRep));
        tables.put("possibleState", Util.get(possibleStateRep));
        model.addAttribute("title", "Возможные состояния переходов");
        model.addAttribute("tables", tables);
        return "possibleState";
    }

    @PostMapping
    public String post(Model model,
        @RequestParam Long idPossibleState,
        @RequestParam Long idState) {
        PossibleState possibleState = possibleStateRep.getOne(idPossibleState);
        possibleState.setTypeState(typeStateRep.findById(idState)
            .orElseThrow(() -> new IllegalArgumentException("Нет такого типового состояния")));
        possibleStateRep.save(possibleState);
        return get(model);
    }
}
