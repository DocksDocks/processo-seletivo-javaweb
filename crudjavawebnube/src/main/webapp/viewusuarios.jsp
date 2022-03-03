<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Visualização de Usuários</title>
</head>
<body>
<%@ page import="com.crudjavawebnube.dao.UsuarioDao, com.crudjavawebnube.bean.*, java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>Listagem de Usuários</h1>
<%
List<Usuario> list = UsuarioDao.getTodosUsuarios();
request.setAttribute("list", list);
%>
<table border="1">
 <tr> 
 <th>ID</th>
 <th>Nome</th>
 <th>Senha</th>
 <th>Email</th>
 <th>Genero</th>
 <th>Nacionalidade</th>
 <th>Editar</th>
 <th>Excluir</th>
 </tr>
 <c:forEach items="${list}" var="usuario">
 <tr>
 <td> ${usuario.getId() } </td>
 <td> ${usuario.getNome() } </td>
 <td> ${usuario.getSenha() } </td>
 <td> ${usuario.getEmail() } </td>
 <td> ${usuario.getGenero() } </td>
 <td> ${usuario.getNacionalidade() } </td>
 <td><a href="editform.jsp?id=${usuario.getId()}">Editar</a></td>
 <td><a href="deleteusuario.jsp?id=${usuario.getId()}">Excluir</a></td>
 </tr>
 </c:forEach>
</table>
<br>
 <a href="addusuarioform.jsp">Adicionar novo usuário </a>
 
</body>
</html>