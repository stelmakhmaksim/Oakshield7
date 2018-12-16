package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.Process;
import com.dms.lab7.repository.ProcessRep;
import com.dms.lab7.repository.ProdRep;
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
@RequestMapping("/proc")
@RequiredArgsConstructor
public class ProcessController {

    private final ProcessRep processRep;
    private final ProdRep prodRep;
    private final TypeProcessRep typeProcessRep;

    @GetMapping
    public String get(Model model) {
        Map<String, List<List<String>>> tables = new HashMap<>();
        tables.put("process", Util.get(processRep));
        tables.put("typeProcess", Util.get(typeProcessRep));
        tables.put("prods", Util.get(prodRep));
        model.addAttribute("title", "Процессы");
        model.addAttribute("tables", tables);
        return "process";
    }

    @PostMapping
    public String post(Model model,
                       @RequestParam String name,
                       @RequestParam Long idProd,
                       @RequestParam Long idProc) {
        Process process = new Process();
        process.setName(name);
        process.setProd(prodRep.findById(idProd).orElseThrow(() -> new IllegalArgumentException("Нет такого изделия")));
        process.setTypePr(typeProcessRep.findById(idProc).orElseThrow(() -> new IllegalArgumentException("Нет такого типового процесса")));
        processRep.save(process);
        return get(model);
    }
}

