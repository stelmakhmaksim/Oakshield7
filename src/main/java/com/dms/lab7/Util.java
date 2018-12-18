package com.dms.lab7;

import com.dms.lab7.entity.Person;
import com.dms.lab7.repository.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;

public class Util {

    private static <T> List<List<String>> getMap(List<String> headers, Function<T, List<String>> func,
        JpaRepository<T, Long> rep) {
        List<List<String>> collect = rep.findAll().stream()
            .map(func)
            .collect(Collectors.toList());
        collect.add(0, headers);
        return collect;
    }

    public static List<List<String>> get(TypeDecisionRep typeDecisionRep) {
        return getMap(Arrays.asList("ID", "Название"),
            dec -> Arrays.asList(dec.getId().toString(), dec.getName()),
            typeDecisionRep);
    }

    public static List<List<String>> get(TypeStateRep typeStateRep) {
        return getMap(Arrays.asList("ID", "Название"),
            state -> Arrays.asList(state.getId().toString(), state.getName()),
            typeStateRep);
    }

    public static List<List<String>> get(Predicate2Rep predicate2Rep) {
        return getMap(Arrays.asList("ID", "Решение", "Состояние"),
            pred -> Arrays.asList(
                pred.getId().toString(),
                "(ИД:" + pred.getDecision().getId() + ") " + pred.getDecision().getName(),
                "(ИД:" + pred.getState().getId() + ") " + pred.getState().getName()
            ),
            predicate2Rep);
    }

    public static List<List<String>> get(FunctRep functRep) {
        return getMap(Arrays.asList("ID", "Название"),
            prod -> Arrays.asList(prod.getId().toString(), prod.getName()),
            functRep);
    }

    public static List<List<String>> get(PersonRep personRep) {
        return getMap(Arrays.asList("ID", "Имя"),
            prod -> Arrays.asList(prod.getId().toString(), prod.getFio()),
            personRep);
    }

    public static List<List<String>> get(GrPersonRep grPersonRep) {
        return getMap(Arrays.asList("ID", "Название", "Включает"),
            gr -> Arrays.asList(
                gr.getId().toString(),
                gr.getName(),
                gr.getPersons() != null ? gr.getPersons().stream()
                    .map(Person::getFio)
                    .collect(Collectors.joining("<br>"))
                    : ""
            ),
            grPersonRep);
    }

    public static List<List<String>> get(FormulaRep formulaRep) {
        return getMap(Arrays.asList("ID", "Функция", "Предикат", "Номер И", "Номер ИЛИ"),
            forml -> Arrays.asList(
                forml.getId().toString(),
                "(ИД:" + forml.getFunct().getId() + ") " + forml.getFunct().getName(),
                forml.getPredicat2().getId().toString(),
                forml.getCon().toString(),
                forml.getDis().toString()
            ),
            formulaRep);
    }

    public static List<List<String>> get(ProdRep prodRep) {
        return getMap(Arrays.asList("ID", "Название"),
            prod -> Arrays.asList(prod.getId().toString(), prod.getName()),
            prodRep);
    }

    public static List<List<String>> get(TypeProcessRep typeProcessRep) {
        return getMap(Arrays.asList("ID", "Название"),
            dec -> Arrays.asList(dec.getId().toString(), dec.getName()),
            typeProcessRep);
    }

    public static List<List<String>> get(StateRep stateRep) {
        return getMap(Arrays.asList("ID", "Типовой процесс", "Типовое состояние", "Функция", "Начальный"),
            state -> Arrays.asList(
                state.getId().toString(),
                "(ИД: " + state.getTypeProcess().getId() + ") " + state.getTypeProcess().getName(),
                "(ИД: " + state.getTypeState().getId() + ") " + state.getTypeState().getName(),
                "(ИД: " + state.getFunct().getId() + ") " + state.getFunct().getName(),
                state.getBegin() ? "1" : "0"
            ),
            stateRep);
    }

    public static List<List<String>> get(PossibleStateRep possibleStateRep) {
        return getMap(Arrays.asList("ID", "Решение", "Состояние", "Возможное состояние перехода"),
            possibleState -> Arrays.asList(
                possibleState.getId().toString(),
                "(ИД: " + possibleState.getPredicat2().getDecision().getId() + ") " + possibleState.getPredicat2()
                    .getDecision().getName(),
                "(ИД: " + possibleState.getPredicat2().getState().getId() + ") " + possibleState.getPredicat2()
                    .getState().getName(),
                "(ИД: " + possibleState.getTypeState().getId() + ") " + possibleState.getTypeState().getName()
        ),
        possibleStateRep);
    }

    public static List<List<String>> get(DecisionRep decisionRep) {
        return getMap(Arrays.asList("ID", "Типовой процесс", "Типовое состояние", "Типовое решение"),
            decision -> Arrays.asList(
                decision.getId().toString(),
                "(ИД: " + decision.getTypeProcess().getId() + ") " + decision.getTypeProcess().getName(),
                "(ИД: " + decision.getState().getId() + ") " + decision.getState().getTypeState().getName(),
                "(ИД: " + decision.getTypeDecision().getId() + ") " + decision.getTypeDecision().getName()
            ),
            decisionRep);
    }

    public static List<List<String>> get(AccessStateRep accessStateRep) {
        return getMap(Arrays.asList("ID", "Типовой процесс", "Типовое состояние", "Группа"),
            perm -> Arrays.asList(
                perm.getId().toString(),
                "(ИД: " + perm.getTypeProcess().getId() + ") " + perm.getTypeProcess().getName(),
                "(ИД: " + perm.getState().getId() + ") " + perm.getState().getTypeState().getName(),
                "(ИД: " + perm.getGrPerson().getId() + ") " + perm.getGrPerson().getName()
            ),
            accessStateRep);
    }

    public static List<List<String>> get(ProcessRep processRep) {
        return getMap(Arrays.asList("ID", "Название", "Изделие", "Типовой процесс"),
            proc -> Arrays.asList(
                proc.getId().toString(),
                proc.getName(),
                "(ИД: " + proc.getProd().getId() + ") " + proc.getProd().getName(),
                "(ИД: " + proc.getTypePr().getId() + ") " + proc.getTypePr().getName()
            ),
            processRep);
    }
}
