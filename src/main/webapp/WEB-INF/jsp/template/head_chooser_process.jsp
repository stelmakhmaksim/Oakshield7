<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.stream.Collectors" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= request.getAttribute("title") %></title>
    <script src="${pageContext.request.contextPath}/generate_table.js"></script>
</head>
<body>
<div style="margin-bottom:30px;">
    <a href="${pageContext.request.contextPath}/constructor">Назад</a>
    <form method="POST">