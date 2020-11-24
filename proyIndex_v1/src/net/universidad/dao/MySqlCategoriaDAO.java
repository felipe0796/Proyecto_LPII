package net.universidad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.universidad.entidad.Categoria;
import net.universidad.entidad.Docente;
import net.universidad.interfaces.CategoriaDAO;
import net.universidad.utils.MySqlBDConexion;

public class MySqlCategoriaDAO implements CategoriaDAO {

	@Override
	public List<Categoria> listAll() {
		List<Categoria> lista=new ArrayList<Categoria>();
		Categoria bean;
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1. conexión a BD
			cn=MySqlBDConexion.getConexion();
			//2.  sentencia SQL
			String sql="select *from tb_categoria";
			//3. enviar la sentencia sql al objeto pstm
			pstm=cn.prepareStatement(sql);
			//4. parámetros (NO EXISTE)
			
			//5. ejecutar sentencia sql
			rs=pstm.executeQuery();
			//6. bucle para realizar recorrido sobre el objeto rs
			while(rs.next()) {
				//7. crear objeto "bean" de la clase Categoria
				bean=new Categoria();
				//8. setear los atributos del objeto "bean" con los valores de fila actual
				bean.setCodigo(rs.getInt(1));
				bean.setNombre(rs.getString(2));
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

}
