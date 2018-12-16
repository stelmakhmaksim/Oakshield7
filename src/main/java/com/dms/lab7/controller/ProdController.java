package com.dms.lab7.controller;

import com.dms.lab7.Util;
import com.dms.lab7.entity.Prod;
import com.dms.lab7.repository.ProdRep;
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
@RequestMapping("/constructor/prod")
@RequiredArgsConstructor
public class ProdController {

    private final ProdRep prodRep;

    @GetMapping
    public String get(Model model) {
        List<List<String>> collect = Util.get(prodRep);
        model.addAttribute("title", "Изделия");
        Map<String, List<List<String>>> res = Collections.singletonMap("prod", collect);
        model.addAttribute("tables", res);
        return "products";
    }

    @PostMapping
    public String post(Model model, @RequestParam String name) {
        Prod prod = new Prod();
        prod.setName(name);
        prodRep.save(prod);
        return get(model);
    }
}

