<%@ page import="com.crudjavawebnube.dao.UsuarioDao"%>
<jsp:useBean id="u" class="com.crudjavawebnube.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
	UsuarioDao.updateUsuario(u);
	response.sendRedirect("viewusuarios.jsp");
%>