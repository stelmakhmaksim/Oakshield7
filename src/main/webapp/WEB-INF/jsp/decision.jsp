<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head.jsp" %>
        <!-- Начало jsp блока -->
        <div><label for="idProc">ИД типового процесса: </label><input id="idProc" name="idProc" type="number" /></div>
        <div><label for="idState">ИД состояния: </label><input id="idState" name="idState" type="number" /></div>
        <div><label for="idDec">ИД типового решения: </label><input id="idDec" name="idDec" type="number" /></div>
        <!-- Конец jsp блока -->
        <div><input value="Добавить" type="submit" /></div>
<%@ include file = "template/footer.jsp" %>