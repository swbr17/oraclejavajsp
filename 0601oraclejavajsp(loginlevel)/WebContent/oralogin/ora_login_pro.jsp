<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%@ page import = "kr.or.ksmart.dao.Mdao" %>

<%
	request.setCharacterEncoding("UTF-8");
	String input_id = request.getParameter("id");
	String input_pw = request.getParameter("pw");
	System.out.println(input_id + "<-- input_id");
	System.out.println(input_pw + "<-- input_pw");
	
	String dbid = null;
	String dbpw = null;
	String dblevel = null;
	String dbname = null;
	String dbemail = null;
	
	Mdao mdao = new Mdao();
	String result =	mdao.mLoginPro(input_id, input_pw);
	if(result.equals("01아이디 일치")){
		session.setAttribute("SNAME", dbname);
		session.setAttribute("SLEVEL", dblevel);
		session.setAttribute("SID", dbid);
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	}else{
		
	}
%>






