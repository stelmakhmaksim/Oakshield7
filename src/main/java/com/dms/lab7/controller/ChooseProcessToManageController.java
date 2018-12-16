package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.repository.TypeProcessRep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/choose_process")
@RequiredArgsConstructor
public class ChooseProcessToManageController {
    private final ManageProcessController manageProcessController;
    private final TypeProcessRep typeProcessRep;

    @GetMapping
    public String main(Model model) {
        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("typeProcess", Util.get(typeProcessRep));
        model.addAttribute("title", "Процессы");
        model.addAttribute("tables", tables);
        return "choose_process";
    }

    @PostMapping
    public ModelAndView post(Model model, @RequestParam Long idProc) {
        return manageProcessController.main(idProc);
    }
}
