<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

   <!-- Begin Wrapper -->
   <div id="wrapper">
   
         <!-- Begin Header -->
         <div id="header">

<%
	String SNAME = (String)session.getAttribute("SNAME");
	String SLEVEL = (String)session.getAttribute("SLEVEL");
	System.out.println(SNAME + "<-- SNAME top.jsp");
	System.out.println(SLEVEL + "<-- SLEVEL top.jsp");
	
	if(SLEVEL == null){
%>
		�α����� �޴�<br>
<a href="<%= request.getContextPath() %>/oraminsert/ora_m_insert_form.jsp">01ȸ������</a><br>
		
	<form action="<%= request.getContextPath() %>/oralogin/ora_login_pro.jsp" method="post">
		���̵� : <input type="text" name="id">
		��� :  <input type="password" name="pw">
		<input type="submit" value="�α��ι�ư">
	</form>
	
<%		
	}else{
		if(SLEVEL.equals("������")){
%>			
		������ �޴�	<br>
	<a href="<%= request.getContextPath() %>/oraminsert/ora_m_insert_form.jsp">01ȸ������</a>
	<a href="<%= request.getContextPath() %>/oramlist/ora_m_list.jsp">02ȸ������Ʈ</a>
	<a href="<%= request.getContextPath() %>/oragoods/ora_goods_insert_form.jsp">03��ǰ���</a>
	<a href="<%= request.getContextPath() %>/oragoods/ora_goods_list01.jsp">04��ǰ����Ʈ</a>		
<%			
		}else if(SLEVEL.equals("�Ǹ���")){
%>			
		�Ǹ��� �޴�<br>
	<a href="<%= request.getContextPath() %>/oraminsert/ora_m_insert_form.jsp">01ȸ������</a>
	<a href="<%= request.getContextPath() %>/oragoods/ora_goods_insert_form.jsp">03��ǰ���</a>
	<a href="<%= request.getContextPath() %>/oragoods/ora_goods_list01.jsp">04��ǰ����Ʈ</a>		
<%			
		}else if(SLEVEL.equals("������")){
%>			
		������ �޴�	<br>
	<a href="<%= request.getContextPath() %>/oraminsert/ora_m_insert_form.jsp">01ȸ������</a>
	<a href="<%= request.getContextPath() %>/oragoods/ora_goods_list01.jsp">04��ǰ����Ʈ</a>		
<%			
		}
%>		
<br><br>
		<%= SNAME %> �� <%= SLEVEL %> ���� �α�����
		<a href="<%= request.getContextPath() %>/oralogin/ora_logout.jsp">
		�α׾ƿ�
		</a>
<%		
	}
%>

  
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		    
		       		 
			   
		 </div>
		 <!-- End Header -->