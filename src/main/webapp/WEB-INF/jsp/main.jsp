<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Главная страница</title>
</head>
<body>
<div><a href="${pageContext.request.contextPath}/prod">Изделия</a></div>
<div><a href="${pageContext.request.contextPath}/typeDec">Типовые решения</a></div>
<div><a href="${pageContext.request.contextPath}/typeState">Типовые состояния</a></div>
<div><a href="${pageContext.request.contextPath}/typeProcess">Типовые процессы</a></div>
<div><a href="${pageContext.request.contextPath}/funct">Функции</a></div>
<div><a href="${pageContext.request.contextPath}/predicate">Предикаты</a></div>
<div><a href="${pageContext.request.contextPath}/formula">Формулы</a></div>
<br>
<div><a href="${pageContext.request.contextPath}/persons">Сотрудники</a></div>
<div><a href="${pageContext.request.contextPath}/grPersons">Группы сотрудников</a></div>
<div><a href="${pageContext.request.contextPath}/grIncl">Включение сотрудников в группу</a></div>
<br>
<div><a href="${pageContext.request.contextPath}/state">Возможные состояния типового процесса</a></div>
<div><a href="${pageContext.request.contextPath}/dec">Возможные решения типового процесса</a></div>
<div><a href="${pageContext.request.contextPath}/perm">Разрешения</a></div>
<br>
<div><a href="${pageContext.request.contextPath}/proc">Процессы</a></div>
</body>
</html>