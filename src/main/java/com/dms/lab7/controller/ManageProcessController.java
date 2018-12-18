package com.dms.lab7.controller;

import com.dms.lab7.entity.Process;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.repository.ProcessRep;
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
    private final ProcessRep processRep;
    @GetMapping
    public String main(Model model, @RequestParam Long idProc) {
        Process currentProc = processRep.getOne(idProc);
        // TODO: Должно быть раскомичено, когда будешь корректно доставать
        // TODO: возможные решения для текущего состояния по iD (нормально реализован метод findAllByProcessId(idProc))
        //List<TypeDecision> allByProcessId = typeDecisionRep.findAllByProcessId(idProc);
        List<TypeDecision> allByProcessId = typeDecisionRep.findAll();
        Map<Process, List<TypeDecision>> processListMap = Collections.singletonMap(currentProc, allByProcessId);
        model.addAttribute("processState", processListMap);
        return "manage";
    }
}
