package net.universidad.fabrica;


import net.universidad.dao.MySqlCategoriaDAO;
import net.universidad.dao.MySqlDocenteDAO;
import net.universidad.dao.MySqlUsuarioDAO;
import net.universidad.interfaces.CategoriaDAO;
import net.universidad.interfaces.DocenteDAO;
import net.universidad.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public DocenteDAO getDocenteDAO() {
		// TODO Auto-generated method stub
		return new MySqlDocenteDAO();
	}

	@Override
	public CategoriaDAO getCategoriaDAO() {
		// TODO Auto-generated method stub
		return new MySqlCategoriaDAO();
	}

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

}
