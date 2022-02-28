<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edição do Usuário</title>
</head>
<body>
<%@ page import="com.crudjavawebnube.dao.UsuarioDao, com.crudjavawebnube.bean.Usuario"%>
<%
	String id = request.getParameter("id");
	Usuario usuario = UsuarioDao.getRegistroById(Integer.parseInt(id));
%>
<h1>Edição do usuário</h1>
<form action="editusuario.jsp" method="post"> </form>
	<input type="text" name="id" value="<%=usuario.getId()%>"/>
	<table>
	<tr>
	<td>Nome: </td>
	<td><input type="text" name="nome" value="<%=usuario.getNome()%>"></td>
	</tr>
	<tr>
	<td>Senha: </td>
	<td><input type="password" name="senha" value="<%=usuario.getSenha()%>"></td>
	</tr>
	<tr>
	<td>Email: </td>
	<td><input type="email" name="email" value="<%=usuario.getEmail()%>"></td>
	</tr>
	<tr>
	<td>Genero:</td>
	<td>
	<input type="radio" name="genero" value="masculino">Masculino
	<input type="radio" name="genero" value="feminino">Feminino
	</td>
	</tr>
	<tr>
	<td>Nacionalidade: </td>
	<td>
	<select name="nacionalidade">
	<option>Brasileiro</option>
	<option>Estrangeiro</option>
	</select>
	</td>
	</tr>
	<tr>
	<td colspan="2"><input type="submit" value="Editar Usuário"> </td>
	</tr>
	</table>
</body>
</html>