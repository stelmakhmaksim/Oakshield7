<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= request.getAttribute("title") %></title>
    <script src="${pageContext.request.contextPath}/generate_table.js"></script>
</head>
<body>
<div style="margin-bottom:30px;">
    <a href="${pageContext.request.contextPath}/choose_process">Назад</a>
    <form method="POST">