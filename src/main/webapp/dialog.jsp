<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 27.11.2022
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <h1>User info</h1>
    <h2>Username: <c:out value="${sessionScope.user.getUsername()}"/></h2>
    <h3>TotalGames: <c:out value="${sessionScope.user.getGameCount()}"/></h3>
</div>
<h4>${currentQuestion.getText()}</h4>
<form action="${pageContext.request.contextPath}/dialog" method="post">
    <label>
        <input type="radio" name="answer" value="${currentAnswers.get(0).getNextQuestionId}" checked>
    </label> ${currentAnswers.get(0).getText()}<br>
    <label>
        <input type="radio" name="answer" value="${currentAnswers.get(1).getNextQuestionId}">
    </label> ${currentAnswers.get(1).getText()}<br>
    <br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
