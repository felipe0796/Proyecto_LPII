package net.universidad.controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.universidad.entidad.Docente;
import net.universidad.service.DocenteService;


@WebServlet("/ServletDocente")
public class ServletDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//declarar objeto del servicio docente "DocenteService"
	private DocenteService docenteService;
	
    public ServletDocente() {
        super();
        //crear objeto modelDocente
        docenteService=new DocenteService();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//recuperar la acción "parámetro" que viene de la página "docente.jsp"
		String tipo=request.getParameter("accion");
		//evaluar tipo
		if(tipo.equals("LISTAR"))
			listado(request,response);
		else if(tipo.equals("REGISTRAR"))
			registrar(request,response);
		else if(tipo.equals("ACTUALIZAR"))
			actualizar(request,response);
		else if(tipo.equals("ELIMINAR"))
			eliminar(request,response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PASO 1: recuperar el código
		String cod=request.getParameter("codigoEliminar");
		//PASO 2: invocar al método delete y almacenar el valor de retorno
		int salida=docenteService.deleteService(Integer.parseInt(cod));
		//PASO 3: validar el valor de salida
		if(salida>0)//ELIMINO BIEN
			request.setAttribute("MENSAJE", "Registro eliminado correctamente...");
		else//ERRORRRRR
			request.setAttribute("MENSAJE", "Error al eliminar el registro...");
		
		//PASO 4: imvocar al mètodo listado
		listado(request, response);
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PASO 1:
			//recuperar los valores del formulario que se encuentra en la página docente.jsp
			//se recupera utilizando el nombre "atributo name"  de los controles
			String cod,nom,pat,mat,sexo,hijos,sueldo,codCategoria;
			cod=request.getParameter("codigo");
			nom=request.getParameter("nombre");
			pat=request.getParameter("paterno");
			mat=request.getParameter("materno");
			sexo=request.getParameter("sexo");
			hijos=request.getParameter("hijos");
			sueldo=request.getParameter("sueldo");
			codCategoria=request.getParameter("categoria");
			
		//PASO 2: validar el valor de la variable cod	
			if(Integer.parseInt(cod)==0){//REGISTRAR			
				//PASO 2.1:
					//crear objeto de la clase "Docente" y setear sus atributos con los valores de las variables declaradas
					//en el paso anterior
					Docente bean=new Docente();
					bean.setNombre(nom);
					bean.setPaterno(pat);
					bean.setMaterno(mat);
					bean.setSexo(sexo);
					bean.setNumHijos(Integer.parseInt(hijos));
					bean.setSueldo(Double.parseDouble(sueldo));
					bean.setCodigoCategoria(Integer.parseInt(codCategoria));
				//PASO 2.2:
					//variable para almacenar el valor de retorno del método save
					int salida;
					salida=docenteService.saveService(bean);
				//PASO 2.3: validar el valor de salida
					if(salida>0)//REGISTRO BIEN
						request.setAttribute("MENSAJE", "Docente registrado correctamente...");
					else//ERRORRRRR
						request.setAttribute("MENSAJE", "Error en el registro...");	
				//PASO 2.4:
					//mostrar la página "docente.jsp"
					listado(request, response);
			}
			else {//ACTUALIZAR
				//PASO 2.1:
				//crear objeto de la clase "Docente" y setear sus atributos con los valores de las variables declaradas
				//en el paso anterior
				Docente bean=new Docente();
				bean.setCodigo(Integer.parseInt(cod));
				bean.setNombre(nom);
				bean.setPaterno(pat);
				bean.setMaterno(mat);
				bean.setSexo(sexo);
				bean.setNumHijos(Integer.parseInt(hijos));
				bean.setSueldo(Double.parseDouble(sueldo));
				bean.setCodigoCategoria(Integer.parseInt(codCategoria));
			//PASO 2.2:
				//variable para almacenar el valor de retorno del método update
				int salida;
				salida=docenteService.updateService(bean);
			//PASO 2.3: validar el valor de salida
				if(salida>0)//ACTUALIZO BIEN
					request.setAttribute("MENSAJE", "Docente actualizado correctamente...");
				else//ERRORRRRR
					request.setAttribute("MENSAJE", "Error en la actualizaciòn...");		
			//PASO 2.4:
				//mostrar la página "docente.jsp"
				listado(request, response);				
			}
			
	}

	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Objeto para almacenar el valor de retorno del método listAll
		List<Docente> lista=docenteService.listAllService();
		//crear un atributo para almcenar el valor del arreglo "lista"
		request.setAttribute("listaDocentes", lista);
		//direccionar a la página "docente.jsp"
		request.getRequestDispatcher("/docente.jsp").forward(request, response);
		
	}

	
	
}









