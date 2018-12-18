<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<table>
    <caption>Название процесса: ${processName}</caption>
    <tr>
        <th>Состояние процесса: <c:out value="${processState.typeState.name}"/></th>
    </tr>
    <tr>
        <!-- Конец jsp блока -->
        <div><label for="id">ИД решения: </label><input id="id" name="id" type="number"
                                                        style="background-color: whitesmoke; color: black; font-family:Verdana;"/>
        </div>
    </tr>
</table>

<div><input value="Создать" type="submit" class="primary"/></div>

<table border="1">
    <caption>Возможные решения</caption>
    <tr>
        <th>ID</th>
        <th>Название</th>
    </tr>
    <c:forEach items="${possibleSolving}" var="possibleSolving">
        <tr>
            <!-- Конец jsp блока -->
            <td><c:out value="${possibleSolving.id}"/></td>
            <td><c:out value="${possibleSolving.name}"/></td>
        </tr>
    </c:forEach>
</table>