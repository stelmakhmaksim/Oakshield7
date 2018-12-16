<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.stream.Collectors" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= request.getAttribute("title") %></title>
    <link rel="icon" type="image/png" href="images/fav.png">
    <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" type="text/css">
    <noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/noscript.css" type="text/css"></noscript>
    <script src="${pageContext.request.contextPath}/generate_table.js"></script>
</head>
<body>
    <div id="wrapper">
        <section id="intro" class="wrapper style1 fullscreen fade-up">
        <div class="inner">
            <h2><%= request.getAttribute("title") %></h2>
        <a href="${pageContext.request.contextPath}/">Назад</a>
        <form method="POST">
