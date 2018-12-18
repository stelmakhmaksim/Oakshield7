package com.dms.lab7.controller;

import com.dms.lab7.entity.Process;
import com.dms.lab7.entity.State;
import com.dms.lab7.entity.Trajectory;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.repository.ProcessRep;
import com.dms.lab7.repository.StateRep;
import com.dms.lab7.repository.TrajectoryRep;
import com.dms.lab7.repository.TypeDecisionRep;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/choose_process/manage")
@RequiredArgsConstructor
public class ManageProcessController {
    private final TypeDecisionRep typeDecisionRep;
    private final ProcessRep processRep;
    private final StateRep stateRep;
    private final TrajectoryRep trajectoryRep;

    @GetMapping
    public String main(Model model, @RequestParam Long idProc) {
        prepareModel(model, idProc);
        return "manage";
    }

    @PostMapping
    public String updateStateByProc(Model model, @RequestParam Long idProc, @RequestParam Long id) {
        System.out.println(id); // id решения
        System.out.println(idProc); // id процесса
        // TODO: Сохранить решение с id для текущего состояния процесса состояния
        ///////////////////////////////////////////////////////////////
        // TODO: отобразить в Model новое состояние с решениями
        prepareModel(model, idProc);
        //////////////////////////////////////////////////////////////

        return "manage";
    }

    private void prepareModel(Model model, @RequestParam Long idProc) {
        Process currentProc = processRep.getOne(idProc);
        // TODO: Должно быть раскомичено, когда будешь корректно доставать
        // TODO: возможные решения для текущего состояния по iD состояния (нормально реализован метод findAllByStateId(idProc))
        //List<TypeDecision> allByStateId = typeDecisionRep.findAllByStateId(idState);
        List<Trajectory> trajectories = stateRep.findStatesByProcessId(idProc).stream()
                .map(State::getId)
                .map(trajectoryRep::findByStateId)
                .collect(Collectors.toList());
        Trajectory currentTrajectory = stateRep.findStatesByProcessId(idProc).stream()
                .map(State::getId)
                .map(trajectoryRep::findByStateId)
                .filter(Trajectory::getIsCurrent)
                .findFirst().get();
        List<TypeDecision> allByStateId = typeDecisionRep.findAll();
        model.addAttribute("processState", currentTrajectory.getState());
        model.addAttribute("processName", currentProc.getName());
        model.addAttribute("possibleSolving", allByStateId);
        model.addAttribute("processTrajectories", trajectories);
        model.addAttribute("title", "Управление процессом");
    }
}
