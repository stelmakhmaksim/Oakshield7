<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>
        <!-- Начало jsp блока -->
        <div><label for="name">Название: </label><input id="name" name="name" type="text" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <div><label for="idProc">ИД типового процесса: </label><input id="idProc" name="idProc" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <div><label for="idProd">ИД изделия: </label><input id="idProd" name="idProd" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <!-- Конец jsp блока -->
        <br>
        <div><input value="Добавить" type="submit" class="primary"/></div>
<%@ include file = "template/footer.jsp" %>