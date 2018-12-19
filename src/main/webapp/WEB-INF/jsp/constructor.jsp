<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ include file = "template/head_constructor_main.jsp" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Конструктор</title>
</head>
<body>
<div><a href="${pageContext.request.contextPath}/constructor/prod">Изделия</a></div>
<div><a href="${pageContext.request.contextPath}/constructor/typeDec">Типовые решения</a></div>
<div><a href="${pageContext.request.contextPath}/constructor/typeState">Типовые состояния</a></div>
<div><a href="${pageContext.request.contextPath}/constructor/typeProcess">Типовые процессы</a></div>
<!-- <div><a href="${pageContext.request.contextPath}/constructor/funct">Функции</a></div> -->
<div><a href="${pageContext.request.contextPath}/constructor/predicate">Предикаты</a></div>
<!-- <div><a href="${pageContext.request.contextPath}/constructor/formula">Формулы</a></div> -->
<br>
<div><a href="${pageContext.request.contextPath}/constructor/persons">Сотрудники</a></div>
<div><a href="${pageContext.request.contextPath}/constructor/grPersons">Группы сотрудников</a></div>
<div><a href="${pageContext.request.contextPath}/constructor/grIncl">Включение сотрудников в группу</a></div>
<br>
<div><a href="${pageContext.request.contextPath}/constructor/state">Возможные состояния типового процесса</a></div>
<div><a href="${pageContext.request.contextPath}/constructor/possibleState">Возможные состояния переходов</a></div>
<div><a href="${pageContext.request.contextPath}/constructor/dec">Возможные решения типового процесса</a></div>

<div><a href="${pageContext.request.contextPath}/constructor/perm">Разрешения</a></div>
<br>
<div><a href="${pageContext.request.contextPath}/constructor/proc">Процессы</a></div>
</body>
</html>