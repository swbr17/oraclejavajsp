<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Gdao" %>

<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="g" class="kr.or.ksmart.dto.Goods"/>
<jsp:setProperty name="g" property="*"/>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/main.css" />

</head>
<body>
<%@ include file="/oramodule/top.jsp" %>
<%@ include file="/oramodule/left.jsp" %>
 <!-- Begin Right Column -->
		 <div id="rightcolumn">
		 
	    상품등록완료	<br><br>
<%
	Gdao gdao = new Gdao();
	gdao.gInsert(g);

	response.sendRedirect(request.getContextPath()+"/oragoods/oraglist/ora_g_list.jsp");
%>
		 </div>
		 <!-- End Right Column -->
		 
<%@ include file="/oramodule/hadan.jsp" %>
</body>
</html>