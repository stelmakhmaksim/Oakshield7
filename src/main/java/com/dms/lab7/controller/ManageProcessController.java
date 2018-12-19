package com.dms.lab7.controller;

import com.dms.lab7.entity.PossibleState;
import com.dms.lab7.entity.Process;
import com.dms.lab7.entity.State;
import com.dms.lab7.entity.Trajectory;
import com.dms.lab7.entity.TypeDecision;
import com.dms.lab7.entity.TypeState;
import com.dms.lab7.repository.PossibleStateRep;
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
    private final PossibleStateRep possibleStateRep;

    @GetMapping
    public String main(Model model, @RequestParam Long idProc) throws Exception {
        return prepareModel(model, idProc, false, 0);
    }

    @PostMapping
    public String updateStateByProc(Model model, @RequestParam Long idProc, @RequestParam Long id) throws Exception {
        return prepareModel(model, idProc, true, id);
    }

    private String prepareModel(Model model, Long idProc, boolean goToAnotherState, long id) throws Exception {
        Process currentProc = processRep.getOne(idProc);
        List<State> statesByProcessId = stateRep.findStatesByProcessId(idProc);
        if (statesByProcessId == null) {
            throw new Exception("Не заданы состояния процесса");
        }
        List<Trajectory> trajectories = statesByProcessId.stream()
                .map(State::getId)
                .flatMap(idState -> trajectoryRep.findByStateId(idState).stream())
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Trajectory savedCurrentTrajectory = null;
        if (trajectories.size() == 0) {
            State currentState = statesByProcessId.stream().filter(State::getBegin).findFirst().orElse(null);
            if (currentState == null) {
                throw new Exception("Не задано начальное состояние");
            } else {
                savedCurrentTrajectory = trajectoryRep.save(Trajectory.builder()
                        .state(currentState)
                        .isCurrent(true)
                        .build());
                trajectories.add(savedCurrentTrajectory);
            }
        }
        if (savedCurrentTrajectory == null) {
            savedCurrentTrajectory = trajectories.stream()
                    .filter(Trajectory::getIsCurrent)
                    .findFirst().get();
        }

        // Тут выполняется условие если мы выбираем како-то решение для нашего состояния,
        // изменненное состояние апдейстится в таблице траектории
        if (goToAnotherState) {
            TypeDecision currentDecision = typeDecisionRep.getOne(id);
            savedCurrentTrajectory.setTypeDecision(currentDecision);
            savedCurrentTrajectory.setIsCurrent(false);
            TypeState typeState = savedCurrentTrajectory.getState().getTypeState();
            TypeDecision decisionName = savedCurrentTrajectory.getTypeDecision();
            List<PossibleState> possibleStates = possibleStateRep.findAll();
            PossibleState possibleState = possibleStates.stream().filter(
                    pr -> pr.getPredicat2().getDecision().equals(decisionName) && pr.getPredicat2().getState()
                            .equals(typeState)).findFirst().orElse(null);
            trajectoryRep.save(savedCurrentTrajectory);
            if (possibleState == null) { // TODO: проверка нашлось ли оно
                currentProc.setIsDone(true);
                processRep.save(currentProc);
                model.addAttribute("processName", currentProc.getName());
                model.addAttribute("processTrajectories", trajectories);
                model.addAttribute("title", "Управление процессом");
                return "processend";
            }
            TypeState typeState1 = possibleState.getTypeState();
            State newState = stateRep
                    .findStatesByProcessIdAndTypeStateId(idProc, typeState1.getId());

            savedCurrentTrajectory = Trajectory.builder().state(newState).isCurrent(true).build();
            trajectoryRep.save(savedCurrentTrajectory);

        }

        TypeState typeState = savedCurrentTrajectory.getState().getTypeState();
        List<PossibleState> possibleStates = possibleStateRep.findAll();

        List<PossibleState> collect = possibleStates.stream().filter(
                pr -> pr.getPredicat2().getState()
                        .equals(typeState)).collect(Collectors.toList());
        List<TypeDecision> allByStateId = collect.stream().map(s -> s.getPredicat2().getDecision())
                .collect(Collectors.toList());

        model.addAttribute("processState", savedCurrentTrajectory.getState());
        model.addAttribute("processName", currentProc.getName());
        model.addAttribute("possibleSolving", allByStateId);
        model.addAttribute("processTrajectories", trajectories.stream().filter(tr -> tr.getTypeDecision() != null).collect(Collectors.toList()));
        model.addAttribute("title", "Управление процессом");
        return "manage";
    }
}
