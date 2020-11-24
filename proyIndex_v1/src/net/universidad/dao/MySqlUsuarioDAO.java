package net.universidad.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.universidad.entidad.Menu;
import net.universidad.entidad.Usuario;
import net.universidad.interfaces.UsuarioDAO;
import net.universidad.utils.MySqlBDConexion;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public Usuario iniciarSesion(String login, String clave) {
		Usuario bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select cod_usuario,usu_nom,concat(ape_pat,' ',ape_mat)" + 
					"from usuario_tr where usu_log=? and usu_psw=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, login);
			pstm.setString(2, clave);
			rs=pstm.executeQuery();
			if(rs.next()) {
				bean=new Usuario();
				bean.setCodigo(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return bean;
	}

	@Override
	public List<Menu> traerMenusDelUsuario(int codUsuario) {
		List<Menu> lista=new ArrayList<Menu>();
		Menu bean=null;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			cn=MySqlBDConexion.getConexion();
			String sql="select m.descripcion,m.url_menu from menu_usuario m join acceso_usuario a on a.cod_menu=m.cod_menu where a.cod_usuario=?";
			pstm=cn.prepareStatement(sql);
			pstm.setInt(1, codUsuario);
			rs=pstm.executeQuery();
			while(rs.next()) {
				bean=new Menu();
				bean.setNombre(rs.getString(1));
				bean.setUrl(rs.getString(2));
				lista.add(bean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return lista;
	}

}
