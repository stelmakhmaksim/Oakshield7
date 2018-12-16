<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!-- Начало jsp блока -->
<!-- Конец jsp блока -->
<c:forEach items="${eList}" var="employee">
    <tr>
        <td>Employee ID: <c:out value="${employee.id}"/></td>
        <td>Employee Pass: <c:out value="${employee.ename}"/></td>
    </tr>
</c:forEach>
