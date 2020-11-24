package net.universidad.interfaces;

import java.util.List;

import net.universidad.entidad.Menu;
import net.universidad.entidad.Usuario;

public interface UsuarioDAO {
	public Usuario iniciarSesion(String login,String clave);
	public List<Menu> traerMenusDelUsuario(int codUsuario);
}
