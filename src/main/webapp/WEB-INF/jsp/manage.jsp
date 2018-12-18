<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<table>
    <caption>Название процесса: ${processName}</caption>
    <c:forEach items="${processState}" var="processState">
        <tr>
            <th>Состояние процесса: <c:out value="${processState.key.typeState.name}"/></th>
        </tr>
        <tr>
            <td>Возможные решения: <c:out value="${processState.value}"/></td>
        </tr>
    </c:forEach>
</table>
