<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function check(){
	return true;
}
</script>
</head>
<body>
	<form:form modelAttribute="memberBean" method="POST">
		帳號:<form:input type="text" path="accountId" id="accountId"/><br>
		密碼:<form:password path="password" id="password"/><br>
		姓名:<form:input path="memberName" id="memberName"/><br>
		生日:<form:input path="birth" type="date" id="birth"/><br>
		性別:<form:radiobutton path="gender" name="gender" value="1" id="gender1"/>男
			<form:radiobutton path="gender" name="gender" value="0" id="gender2"/>女<br>
		Email:<form:input path="email" id="email"/><br>
<%-- 		上傳證件圖片: <form:input path="photo1" type="file"/><br> --%>
<%-- 				    <form:input path="photo2" type="file"/><br> --%>
		自我介紹:<form:input path="introduction"/><br>
		<input type="submit" value="送出" onclick="return check()">
	</form:form>
</body>
</html>