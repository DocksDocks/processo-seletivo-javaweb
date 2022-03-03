package com.crudjavawebnube.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.crudjavawebnube.bean.Usuario;

public class UsuarioDao {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root" , "" );
			} catch(Exception e) {
				 System.out.println(e);
			}
		return con;
	}
	
	public static int salvarUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) 
					con.prepareStatement("INSERT INTO usuario (nome,senha,email,genero,nacionalidade) VALUES (?,?,?,?,?)");
			ps.setString(1, u.getNome());
			ps.setString(2, u.getSenha());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getGenero());
			ps.setString(5, u.getNacionalidade());
			status = ps.executeUpdate();
				}catch(Exception e) {
					System.out.println(e);
				}
				return status;
		}
	
	public static int deletarUsuario(Usuario u) {
int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) 
					con.prepareStatement("DELETE FROM usuario WHERE id=?");
	ps.setInt(1, u.getId());
	status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	


public static List<Usuario> getTodosUsuarios(){
	List<Usuario> list = new ArrayList<Usuario>();
	
	try {
		Connection con = getConnection();
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM usuario");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Usuario usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEmail(rs.getString("email"));
			usuario.setGenero(rs.getString("genero"));
			usuario.setNacionalidade(rs.getString("nacionalidade"));
			list.add(usuario);
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	return list;
}

public static Usuario getRegistroById(int id) {
	Usuario usuario = null;
	try {
		Connection con = getConnection();
		PreparedStatement ps = (PreparedStatement) 
				con.prepareStatement("SELECT * FROM usuario WHERE id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			usuario = new Usuario();
			usuario.setId(rs.getInt("id"));
			usuario.setNome(rs.getString("nome"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setEmail(rs.getString("email"));
			usuario.setGenero(rs.getString("genero"));
			usuario.setNacionalidade(rs.getString("nacionalidade"));
		}
	}catch(Exception e) {
		System.out.println(e);
	}
	return usuario;
}

	public static int updateUsuario(Usuario u) {
		int status = 0;
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) 
					con.prepareStatement("UPDATE usuario SET nome=?," 
			+ "senha=?, email=?, genero=?, nacionalidade=? WHERE id=?");
			
	ps.setString(1, u.getNome());
	ps.setString(2, u.getSenha());
	ps.setString(3, u.getEmail());
	ps.setString(4, u.getGenero());
	ps.setString(5, u.getNacionalidade());
	ps.setInt(6, u.getId());
	status = ps.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
}
	
	public static List<Usuario> getRecords(int start, int total){
		List<Usuario> list = new ArrayList<Usuario>();
		
		try {
			Connection con = getConnection();
			PreparedStatement ps = (PreparedStatement) 
					con.prepareStatement("SELECT * FROM LIMIT"+(start)+","+total);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setEmail(rs.getString("email"));
				usuario.setGenero(rs.getString("genero"));
				usuario.setNacionalidade(rs.getString("nacionalidade"));
				list.add(usuario);
			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}
}




