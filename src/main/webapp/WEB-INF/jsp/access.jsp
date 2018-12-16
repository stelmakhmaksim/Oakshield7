<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>
        <!-- Начало jsp блока -->
        <div><label for="idProc">ИД типового процесса: </label><input id="idProc" name="idProc" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <div><label for="idState">ИД состояния: </label><input id="idState" name="idState" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <div><label for="idGr">ИД группы, которая может принимать решения в данном состоянии: </label><input id="idGr" name="idGr" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <!-- Конец jsp блока -->
        <br>
        <div><input value="Добавить" type="submit" class="primary"/></div>
<%@ include file = "template/footer.jsp" %>