<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>
        <!-- Начало jsp блока -->
        <div><label for="idProc">ИД предиката: </label><input id="idProc" name="idProc" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <div><label for="idState">ИД типового состояния: </label><input id="idState" name="idState" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
<!--<div><label for="idFunc">ИД функции перехода в состояние: </label><input id="idFunc" name="idFunc" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div> -->
        <div><label for="beg">Начало(0 - нет): </label><input id="beg" name="beg" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <!-- Конец jsp блока -->
        <br>
        <div><input value="Добавить" type="submit" class="primary"/></div>
<%@ include file = "template/footer.jsp" %>