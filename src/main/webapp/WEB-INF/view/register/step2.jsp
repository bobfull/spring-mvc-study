<%--
  Created by IntelliJ IDEA.
  User: kakao
  Date: 2019-03-08
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title><spring:message code="member.register"/></title>
</head>
<body>
    <h2><spring:message code="member.info"/></h2>
    <form:form action="step3" modelAttribute="registerRequest">
        <p>
            <label><spring:message code="email"/> </label>
            <form:input path="email" />
        </p>
        <p>
            <label><spring:message code="name"/></label>
            <form:input path="name" />
        </p>

        <p>
            <label><spring:message code="password"/></label>
            <form:password path="password" />
        </p>

        <p>
            <label><spring:message code="password.confirm"/></label>
            <form:password path="confirmPassword" />
        </p>
        <input type="submit" value="<spring:message code="register.btn"/>"/>
    </form:form>
</body>
</html>
