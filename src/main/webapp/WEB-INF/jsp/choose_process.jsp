<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_main.jsp" %>
<br>
<!-- Начало jsp блока -->
<form action="${pageContext.request.contextPath}/choose_process/manage" method ="GET">
    ИД процесса: <input id="idProc" name="idProc" type="number" class="wrapper" style="background-color: whitesmoke; color: black; font-family:Verdana;"/> <br><br>
    <input value="Перейти к управлению этим процессом" type="submit" class="primary"/>
    <!-- Конец jsp блока -->
</form>

<%@ include file = "template/footer.jsp" %>