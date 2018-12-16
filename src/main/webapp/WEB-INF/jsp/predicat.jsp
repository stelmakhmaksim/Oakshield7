<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>
        <!-- Начало jsp блока -->
        <div><label for="decId">Ид типового решения: </label><input id="decId" name="decId" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <div><label for="stateId">Ид типового состояния: </label><input id="stateId" name="stateId" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <!-- Конец jsp блока -->
        <br>
        <div><input value="Создать" type="submit" class="primary"/></div>
<%@ include file = "template/footer.jsp" %>