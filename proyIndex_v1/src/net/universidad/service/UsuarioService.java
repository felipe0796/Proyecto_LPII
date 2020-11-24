package net.universidad.service;
import java.util.List;

import net.universidad.entidad.Menu;
import net.universidad.entidad.Usuario;
import net.universidad.fabrica.DAOFactory;
import net.universidad.interfaces.UsuarioDAO;

public class UsuarioService {
	//1. definir gestor de base de datos
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	//2. definir uno o màs interfaces
	UsuarioDAO daoUsuario=fabrica.getUsuarioDAO();
	
	public Usuario sesion(String login,String clave){
		return daoUsuario.iniciarSesion(login, clave);
	}
	public List<Menu> traerMenus(int codUsuario){
		return daoUsuario.traerMenusDelUsuario(codUsuario);
	}
	
}
