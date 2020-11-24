package net.universidad.fabrica;

import net.universidad.dao.SqlServerDocenteDAO;
import net.universidad.interfaces.CategoriaDAO;
import net.universidad.interfaces.DocenteDAO;
import net.universidad.interfaces.UsuarioDAO;

public class SqlSeverDAOFactory extends DAOFactory {

	@Override
	public DocenteDAO getDocenteDAO() {
		// TODO Auto-generated method stub
		return new SqlServerDocenteDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return null;
	}

}
