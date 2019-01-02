<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_processes.jsp" %>

Название процесса: ${processName}
<br>
Состояние процесса: <c:out value="${processState.typeState.name}"/>
<br>
<label for="id">ИД решения: </label><input id="id" name="id" type="number"
                                           style="background-color: whitesmoke; color: black; font-family:Verdana;"/>
<br>

<div><input value="Создать" type="submit" class="primary"/></div>

<table border="1">
    <caption>Возможные решения состояния <c:out value="${processState.typeState.name}"/></caption>
    <tr>
        <th>ID</th>
        <th>Название</th>
    </tr>
    <c:forEach items="${possibleSolving}" var="possibleSolving">
        <tr>
            <td><c:out value="${possibleSolving.id}"/></td>
            <td><c:out value="${possibleSolving.name}"/></td>
        </tr>
    </c:forEach>
</table>

<table border="1">
    <caption>Траектория процесса ${processName}</caption>
    <tr>
        <th>ИД</th>
        <th>Состояние процесса</th>
        <th>Решение</th>
    </tr>
    <c:forEach items="${processTrajectories}" var="processTrajectories">
        <tr>
            <td><c:out value="${processTrajectories.id}"/></td>
            <td><c:out value="${processTrajectories.state.typeState.name}"/></td>
            <td><c:out value="${processTrajectories.typeDecision.name}"/></td>
        </tr>
    </c:forEach>
</table>