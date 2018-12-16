package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.TypeProcess;
import com.dms.lab7.repository.TypeProcessRep;
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
@RequestMapping("/typeProcess")
@RequiredArgsConstructor
public class TypeProcessController {

    private final TypeProcessRep typeProcessRep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(typeProcessRep);
        model.addAttribute("title", "Типы процессов");
        Map<String, List<List<String>>> res = Collections.singletonMap("typeProcess", collect);
        model.addAttribute("tables", res);
        return "typeProcess";
    }

    @PostMapping
    public String post(Model model, @RequestParam String name) {
        TypeProcess dec = new TypeProcess();
        dec.setName(name);
        typeProcessRep.save(dec);
        return get(model);
    }
}

