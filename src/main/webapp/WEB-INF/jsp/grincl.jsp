<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>
        <!-- Начало jsp блока -->
        <div><label for="id">ИД группы: </label><input id="id" name="id" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <div><label for="personId">ИД сотрудника: </label><input id="personId" name="personId" type="number" style="background-color: whitesmoke; color: black; font-family:Verdana;"/></div>
        <!-- Конец jsp блока -->
        <br>
        <div><input value="Добавить" type="submit" class="primary"/></div>
<%@ include file = "template/footer.jsp" %>