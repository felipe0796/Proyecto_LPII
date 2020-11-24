package net.universidad.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.universidad.entidad.Menu;
import net.universidad.entidad.Usuario;
import net.universidad.service.UsuarioService;
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//
	private UsuarioService servicioUsuario;
	public ServletUsuario() {
        super();
        servicioUsuario=new UsuarioService();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion=request.getParameter("accion");
		if(accion.equals("INICIAR"))
			iniciarSesion(request,response);
		else if(accion.equals("CERRAR"))
			cerrarSession(request,response);
	}
	private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login,clave;
		login=request.getParameter("login");
		clave=request.getParameter("clave");
		//invocar al mètodo sesion
		Usuario bean=servicioUsuario.sesion(login, clave);
		//validar objeto bean
		if(bean==null) {
			request.setAttribute("MENSAJE","Usuario y/o clave incorrectos..");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			//obtener el codigo del usuario actual
			int codigo;
			codigo=bean.getCodigo();
			//invocar al mètodo traerMenus
			List<Menu> lista=servicioUsuario.traerMenus(codigo);
			//crear una sesiòn 
			HttpSession session=request.getSession();
			//crear atributos dentro del objeto session
			session.setAttribute("menus", lista);
			session.setAttribute("usuario", bean);
			request.getRequestDispatcher("/menuGeneral.jsp").forward(request, response);
		}
	}
	private void cerrarSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener sesiòn actual 
		HttpSession session=request.getSession();
		//invalidar sesiòn actual
		session.invalidate();
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

}
