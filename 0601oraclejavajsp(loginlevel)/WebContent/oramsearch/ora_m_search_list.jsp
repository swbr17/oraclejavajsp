<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.util.*" %>
<%@ page import = "kr.or.ksmart.dto.Member" %>
<%@ page import = "kr.or.ksmart.dao.Mdao" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�˻����</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/main.css" />
												<!-- /layout02/main.css -->
</head>
<body>

<%@ include file="../oramodule/top.jsp" %>
<%@ include file="../oramodule/left.jsp" %>
		 <!-- Begin Right Column -->
		 <div id="rightcolumn">

	ȸ�� ����Ʈ <br>
	<table width="100%" border="1">
	<tr>
		<a href="../oramlist/ora_m_list.jsp">��ü����Ʈ ���ư���</a>
	</tr>
	<tr>
		<td>���̵�</td><td>���</td><td>����</td><td>�̸�</td><td>�̸���</td><td>����</td><td>����</td>
	</tr>

<%
	request.setCharacterEncoding("euc-kr");
	String search = request.getParameter("search");
	System.out.println(search+" <-- search search_list.jsp");
	Mdao mdao = new Mdao();
	ArrayList<Member> list = mdao.mSearch(search);
	for(Member m : list){
%>
	<tr>
		<td><%= m.getOra_id() %></td>
		<td><%= m.getOra_pw() %></td>
		<td><%= m.getOra_level() %></td>
		<td><%= m.getOra_name() %></td>
		<td><%= m.getOra_email() %></td>
		<td><a href="../oramupdate/ora_m_update_form.jsp?send_id=<%= m.getOra_id() %>">����</a></td>
		<td><a href="../oramdelete/ora_m_delete_pro.jsp?send_id=<%= m.getOra_id() %>">����</a></td>
	</tr>
<%		
	}
%>

</table>
</div>
<!-- End Right Column -->
<%@ include file="../oramodule/hadan.jsp" %>
</body>
</html>
