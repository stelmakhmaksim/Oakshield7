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
import java.util.Objects;
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
    public String main(Model model, @RequestParam Long idProc) throws Exception {
        prepareModel(model, idProc, false, 0);
        return "manage";
    }

    @PostMapping
    public String updateStateByProc(Model model, @RequestParam Long idProc, @RequestParam Long id) throws Exception {
        System.out.println(id); // id решения
        System.out.println(idProc); // id процесса
        prepareModel(model, idProc, true, id);
        return "manage";
    }

    private void prepareModel(Model model, Long idProc, boolean goToAnotherState, long id) throws Exception {
        Process currentProc = processRep.getOne(idProc);
        List<State> statesByProcessId = stateRep.findStatesByProcessId(idProc);
        if (statesByProcessId == null) {
            throw new Exception("Не заданы состояния процесса");
        }
        List<Trajectory> trajectories = statesByProcessId.stream()
                .map(State::getId)
                .map(trajectoryRep::findByStateId)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Trajectory savedCurrentTrajectory = null;
        if (trajectories.size() == 0) {
            State currentState = statesByProcessId.stream().filter(State::getBegin).findFirst().orElse(null);
            if (currentState == null){
                throw new Exception("Не задано начальное состояние");
            } else {
                savedCurrentTrajectory = trajectoryRep.save(Trajectory.builder()
                        .state(currentState)
                        .isCurrent(true)
                        .build());
                trajectories.add(savedCurrentTrajectory);
            }
        }
        if (savedCurrentTrajectory == null){
            savedCurrentTrajectory = trajectories.stream()
                    .filter(Trajectory::getIsCurrent)
                    .findFirst().get();
        }

        // Тут выполняется условие если мы выбираем како-то решение для нашего состояния,
        // изменненное состояние апдейстится в таблице траектории
        if (goToAnotherState){
            TypeDecision currentDecision = typeDecisionRep.getOne(id);
            savedCurrentTrajectory.setTypeDecision(currentDecision);
            trajectoryRep.save(savedCurrentTrajectory);
            //// TODO: Тут мы сохраняем измененную траекторию и ты должен присвоить
            //// TODO: savedCurrentTrajectory = следующее_состояние_для_этого_процесса
            //// TODO: и записать это новое состояние в таблицу Траектория  Trajectory.builder().state(новое_состояние).isCurrent(true).build()
        }
        // TODO: Должно быть раскомичено, когда будешь корректно доставать
        // TODO: возможные решения для текущего состояния по iD состояния (нормально реализован метод findAllByStateId(idProc))
        //List<TypeDecision> allByStateId = typeDecisionRep.findAllByStateId(idState);

        List<TypeDecision> allByStateId = typeDecisionRep.findAll();
        model.addAttribute("processState", savedCurrentTrajectory.getState());
        model.addAttribute("processName", currentProc.getName());
        model.addAttribute("possibleSolving", allByStateId);
        model.addAttribute("processTrajectories", trajectories);
        model.addAttribute("title", "Управление процессом");
    }
}
