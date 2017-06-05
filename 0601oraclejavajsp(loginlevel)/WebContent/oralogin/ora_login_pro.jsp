<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%@ page import = "kr.or.ksmart.dao.Mdao" %>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	System.out.println(id + "<-- input_id");
	System.out.println(pw + "<-- input_pw");
	
	Mdao mdao = new Mdao();
	String result =	mdao.mLoginCheck(id, pw);
	if(result.equals("로그인성공")){
		Member sessionresult = mdao.mGetSession(id);
		request.getSession();
		session.setAttribute("SNAME", sessionresult.getOra_name());
		session.setAttribute("SLEVEL", sessionresult.getOra_level());
		session.setAttribute("SID", sessionresult.getOra_id());
%>
	<script language="javascript">
		alert("로그인성공");
		location.href = "<%= request.getContextPath() %>/index.jsp";
	</script>
<%			
	}else{
%>
	<script language="javascript">
		alert("로그인을 다시 시도해주시기 바랍니다.");
		location.href = "<%= request.getContextPath() %>/index.jsp";
	</script>
<%
	}
%>






