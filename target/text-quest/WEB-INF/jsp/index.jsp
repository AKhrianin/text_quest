<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

<body>
<h1>Start page</h1>
<h3>Вы просыпаетесь в тёмном холодном месте, похоже, что это пещера. Пытаясь привести мысли в порядок, вы вспоминаете.</h3>
<form action="${pageContext.request.contextPath}/user" method="post">
    <div>
        <label for="name">Ваше имя:</label>
        <input type="text" id="name" name="username">
    </div>
    <div class="button">
        <button type="submit" class="btn btn-success">Go</button>
    </div>
</form>
</body>
</html>
