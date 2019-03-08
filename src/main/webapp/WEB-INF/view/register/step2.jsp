<%--
  Created by IntelliJ IDEA.
  User: kakao
  Date: 2019-03-08
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <h2>회원 정보 입력</h2>
    <form:form action="step3" modelAttribute="registerRequest">
        <p>
            <label>이메일 :</label>
            <form:input path="email" />
        </p>
        <p>
            <label>이름 :</label>
            <form:input path="name" />
        </p>

        <p>
            <label>비밀번호 :</label>
            <form:password path="password" />
        </p>

        <p>
            <label>비밀번호 확인 :</label>
            <form:password path="confirmPassword" />
        </p>
    </form:form>
</body>
</html>
