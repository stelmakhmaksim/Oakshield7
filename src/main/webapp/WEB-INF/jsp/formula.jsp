<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>
        <!-- Начало jsp блока -->
        <div><label for="funcId">ИД функции: </label><input id="funcId" name="funcId" type="number" /></div>
        <div><label for="conNum">Номер И: </label><input id="conNum" name="conNum" type="number" /></div>
        <div><label for="disNum">Номер ИЛИ: </label><input id="disNum" name="disNum" type="number" /></div>
        <div><label for="predId">ИД предиката: </label><input id="predId" name="predId" type="number" /></div>
        <!-- Конец jsp блока -->
        <div><input value="Создать" type="submit" /></div>
<%@ include file = "template/footer.jsp" %>