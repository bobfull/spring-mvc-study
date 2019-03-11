<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kakao
  Date: 2019-03-11
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="change.pwd.title"/></title>
</head>
<body>
    <form:form>
        <p>
            <label>
                <spring:message code="currentPassword" />:<br>
                <form:input path="currentPassword"/>
                <form:errors path="currentPassword"/>
            </label>
        </p>
        <p>
            <label>
                <spring:message code="newPassword" />:<br>
                <form:input path="newPassword"/>
                <form:errors path="newPassword"/>
            </label>
        </p>
        <input type="submit" value="<spring:message code="change.btn"/>">
    </form:form>
</body>
</html>
