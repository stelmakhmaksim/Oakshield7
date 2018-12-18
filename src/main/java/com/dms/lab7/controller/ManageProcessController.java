package com.dms.lab7.controller;

import com.dms.lab7.entity.Process;
import com.dms.lab7.entity.State;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.repository.ProcessRep;
import com.dms.lab7.repository.StateRep;
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
    private final StateRep stateRep;
    @GetMapping
    public String main(Model model, @RequestParam Long idProc) {
        Process currentProc = processRep.getOne(idProc);
        // TODO: Должно быть раскомичено, когда будешь корректно доставать
        // TODO: возможные решения для текущего состояния по iD состояния (нормально реализован метод findAllByStateId(idProc))
        // TODO: findCurrentStateByProcessId достает текущее состояние процесса с idProc
        //List<TypeDecision> allByStateId = typeDecisionRep.findAllByStateId(idState);
        // State currentStateByProcessId = stateRep.findCurrentStateByProcessId(idProc);
        State currentStateByProcessId = stateRep.findAll().get(0);
        List<TypeDecision> allByStateId = typeDecisionRep.findAll();
        Map<State, List<TypeDecision>> processListMap = Collections.singletonMap(currentStateByProcessId, allByStateId);
        model.addAttribute("processState", processListMap);
        model.addAttribute("processName", currentProc.getName());
        return "manage";
    }
}
