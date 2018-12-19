<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>
    <!-- Начало jsp блока -->
    <div><label for="idPossibleState">ИД типового процесса: </label><input id="idProcess" name="idProcess" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
    <div><label for="idPossibleState">ИД предиката: </label><input id="idPossibleState" name="idPossibleState" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
    <div><label for="idState">ИД возможного типового состояния: </label><input id="idState" name="idState" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
    <!-- Конец jsp блока -->
    <br>
    <div><input value="Добавить" type="submit" class="primary" onClick="submit1()"/></div>
<%@ include file = "template/footer.jsp" %>