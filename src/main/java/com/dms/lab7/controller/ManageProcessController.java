package com.dms.lab7.controller;

import com.dms.lab7.entity.Process;
import com.dms.lab7.entity.State;
import com.dms.lab7.entity.Trajectory;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.repository.ProcessRep;
import com.dms.lab7.repository.StateRep;
import com.dms.lab7.repository.TypeDecisionRep;
import java.util.Arrays;
import java.util.List;
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
    //private final TrajectoryRep trajectoryRep;

    private List<Trajectory> getTrajectories(Long idProc){
        Trajectory trajectory1 = new Trajectory(1L, stateRep.getOne(1L), typeDecisionRep.getOne(1L));
        Trajectory trajectory2 = new Trajectory(3L, stateRep.getOne(2L), typeDecisionRep.getOne(2L));
        //return trajectoryRep.saveAll(Arrays.asList(trajectory1, trajectory2, trajectory3, trajectory4));
        return Arrays.asList(trajectory1, trajectory2);

    }

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
        // TODO: findCurrentStateByProcessId достает текущее состояние процесса с idProc
        // State currentStateByProcessId = stateRep.findCurrentStateByProcessId(idProc);
        // TODO: findAllByProcessId достает историю изменений процесса idProc
        //List<Trajectory> allByProcessId = trajectoryRep.findAllByProcessId(idProc);
        State currentStateByProcessId = stateRep.findAll().get(0);
        List<TypeDecision> allByStateId = typeDecisionRep.findAll();
        model.addAttribute("processState", currentStateByProcessId);
        model.addAttribute("processName", currentProc.getName());
        model.addAttribute("possibleSolving", allByStateId);
        model.addAttribute("processTrajectory", getTrajectories(idProc));
        model.addAttribute("title", "Управление процессом");
    }
}
