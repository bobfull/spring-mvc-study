<%--
  Created by IntelliJ IDEA.
  User: kakao
  Date: 2019-03-08
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>설문조사</title>
</head>
<body>
    <h2>설문조사</h2>
    <form method="post">
        <p>
            1. 역할 <br/>
            <label><input type="radio" name ="responses[0]" value="서버">서버</label>
            <label><input type="radio" name ="responses[0]" value="클라">클라</label>
            <label><input type="radio" name ="responses[0]" value="풀스택">풀스택</label>
        </p>
        <p>
            2. 개발도구 <br/>
            <label><input type="radio" name ="responses[1]" value="이클립스">이클립스</label>
            <label><input type="radio" name ="responses[1]" value="인텔리제이">인텔리제이</label>
            <label><input type="radio" name ="responses[1]" value="서브마린">서브마린</label>
        </p>
        <p>
            3. 하고싶은말 <br/>
            <input type="text" name="responses[2]">
        </p>
        <p>
            <label>응답자 위치: <br>
            <input type="text" name="res.location">
            </label>
        </p>
        <p>
            <label>응답자 나이: <br>
            <input type="text" name="res.age">
            </label>
        </p>
        <input type="submit" value="전송">
    </form>

</body>
</html>
