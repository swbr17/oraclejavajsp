<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dao.Mdao" %>
<% 	request.setCharacterEncoding("UTF-8"); %>

<jsp:useBean id="m" class="kr.or.ksmart.dto.Member"/>
<jsp:setProperty name="m" property="*"/>
<%
	Mdao mdao = new Mdao();
	mdao.mUpdate(m);
	response.sendRedirect(request.getContextPath() + "/oramlist/ora_m_list.jsp");
%>