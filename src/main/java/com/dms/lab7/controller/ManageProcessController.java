package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.repository.TypeDecisionRep;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/choose_process/manage")
@RequiredArgsConstructor
public class ManageProcessController {
    private final TypeDecisionRep typeDecisionRep;
    @GetMapping
    public String main(Model model, @RequestParam Long idProc) {
        List<List<String>> collect = Util.getByDecisionsState(typeDecisionRep, idProc);
        Map<String, List<List<String>>> res = Collections.singletonMap("typeDec", collect);
        model.addAttribute("tables", res);
        return "manage";
    }
}
