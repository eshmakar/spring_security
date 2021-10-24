<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>

</head>
<body>

<h3>Information for all employees</h3> <%--эту надпись смогут увидеть все--%>
<br><br>


<%--ограничиваем видимости кнопки Salary и надпись Only for HR staff!  --%>
<security:authorize access="hasRole('HR')"> <%-- будет доступна только HR-ам--%>
<input type="button" value="Salary" onclick="window.location.href = 'hr_info'">
Only for HR staff!
</security:authorize>
<br><br>


<%--ограничиваем видимости кнопки Performance и надпись Only for Managers!  --%>
<security:authorize access="hasRole('MANAGER')"> <%-- будет доступна только MANAGER-ам--%>
<input type="button" value="Performance" onclick="window.location.href = 'manager_info'">
Only for Managers!
</security:authorize>
</body>
</html>
