<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<c:forEach items="${processState}" var="processState">
    <tr>
        <td>Состояние процесса: <c:out value="${processState.key.name}"/></td>
        <td>Возможные решения: <c:out value="${processState.value}"/></td>
    </tr>
</c:forEach>
