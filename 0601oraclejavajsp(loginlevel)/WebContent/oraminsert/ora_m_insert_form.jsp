<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원정보입력</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/main.css" />
												<!-- /layout02/main.css -->
</head>
<body>

<%@ include file="../oramodule/top.jsp" %>
<%@ include file="../oramodule/left.jsp" %>
		 <!-- Begin Right Column -->
		 <div id="rightcolumn">
		 
		 
<form action="<%= request.getContextPath() %>/oraminsert/ora_m_insert_pro.jsp" method="post">
<table border="1">
<tr>
	<td>아이디</td>
	<td><input type="text" name="ora_id" size="20"></td>
<tr>
<tr>
	<td>암호</td>
	<td><input type="text" name="ora_pw" size="20"></td>
<tr>
<tr>
	<td>권한</td>
	<td><input type="text" name="ora_level" size="20"></td>
<tr>
<tr>
	<td>이름</td>
	<td><input type="text" name="ora_name" size="20"></td>
<tr>
<tr>
	<td>이메일</td>
	<td><input type="text" name="ora_email" size="20"></td>
<tr>
<tr>
	<td colspan="4"><input type="submit" value="회원가입버튼"></td>
</tr>
</table>
</form>



		 </div>
		 <!-- End Right Column -->
<%@ include file="../oramodule/hadan.jsp" %>