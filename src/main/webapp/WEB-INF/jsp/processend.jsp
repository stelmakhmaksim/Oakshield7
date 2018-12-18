<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructors.jsp" %>

Процесс ${processName} завершен.

<table border="1">
    <caption>Траектория процесса ${processName}</caption>
    <tr>
        <th>Состояние процесса</th>
        <th>Решение</th>
    </tr>
    <c:forEach items="${processTrajectories}" var="processTrajectories">
        <tr>
            <td><c:out value="${processTrajectories.state.typeState.name}"/></td>
            <td><c:out value="${processTrajectories.typeDecision.name}"/></td>
        </tr>
    </c:forEach>
</table>