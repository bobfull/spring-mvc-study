<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kakao
  Date: 2019-03-11
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>메인</title>
</head>
<body>
    <p>환영합니다</p>
    <p><a href="<c:url value="/login" />"/>[로그인 하기]</p>
    <p><a href="<c:url value="/register/step1" />"/>[회원 가입하기]</p>
</body>
</html>
