package net.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.universidad.entidad.Docente;
import net.universidad.interfaces.DocenteDAO;
import net.universidad.utils.MySqlBDConexion;

public class MySqlDocenteDAO implements DocenteDAO {

	@Override
	public List<Docente> listAll(){
		List<Docente> lista=new ArrayList<Docente>();
		Docente bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1. conexión a BD
			cn=MySqlBDConexion.getConexion();
			//2.  sentencia SQL
			String sql="select *from tb_docente";
			//3. enviar la sentencia sql al objeto pstm
			pstm=cn.prepareStatement(sql);
			//4. parámetros (NO EXISTE)
			
			//5. ejecutar sentencia sql
			rs=pstm.executeQuery();
			//6. bucle para realizar recorrido sobre el objeto rs
			while(rs.next()) {
				//7. crear objeto "bean" de la clase Docente
				bean=new Docente();
				//8. setear los atributos del objeto "bean" con los valores de fila actual
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setPaterno(rs.getString(3));
				bean.setMaterno(rs.getString(4));
				bean.setSexo(rs.getString(5));
				bean.setNumHijos(rs.getInt(6));
				bean.setSueldo(rs.getDouble(7));
				bean.setCodigoCategoria(rs.getInt(8));
				//9. adicionar el objeto "bean" al arreglo "lista"
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
	
	@Override
	public int save(Docente bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1 conex.
			cn=MySqlBDConexion.getConexion();
			//2 sql
			String sql="insert into tb_docente values(null,?,?,?,?,?,?,?)";
			//3 enviar SQl al objeto "pstm"
			pstm=cn.prepareStatement(sql);
			//4 parámetros
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getPaterno());
			pstm.setString(3, bean.getMaterno());
			pstm.setString(4, bean.getSexo());
			pstm.setInt(5, bean.getNumHijos());
			pstm.setDouble(6, bean.getSueldo());
			pstm.setInt(7, bean.getCodigoCategoria());
			//5 ejecutar
			salida=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}
	@Override
	public int delete(int cod) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1 conex.
			cn=MySqlBDConexion.getConexion();
			//2 sql
			String sql="delete from tb_docente where cod_doc=?";
			//3 enviar SQl al objeto "pstm"
			pstm=cn.prepareStatement(sql);
			//4 parámetros
			pstm.setInt(1, cod);
			//5 ejecutar
			salida=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}	
	
	@Override
	public int update(Docente bean) {
		int salida=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1 conex.
			cn=MySqlBDConexion.getConexion();
			//2 sql
			String sql="update tb_docente set nom_doc=?,pat_doc=?,mat_doc=?,"+
						"sex_doc=?,num_hijo_doc=?,sue_doc=?,cod_cat=? where cod_doc=?";
			//3 enviar SQl al objeto "pstm"
			pstm=cn.prepareStatement(sql);
			//4 parámetros
			pstm.setString(1, bean.getNombre());
			pstm.setString(2, bean.getPaterno());
			pstm.setString(3, bean.getMaterno());
			pstm.setString(4, bean.getSexo());
			pstm.setInt(5, bean.getNumHijos());
			pstm.setDouble(6, bean.getSueldo());
			pstm.setInt(7, bean.getCodigoCategoria());
			pstm.setInt(8, bean.getCodigo());
			//5 ejecutar
			salida=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return salida;
	}	
	
}
