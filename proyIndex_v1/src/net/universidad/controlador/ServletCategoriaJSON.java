package net.universidad.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import net.universidad.entidad.Categoria;
import net.universidad.service.DocenteService;

@WebServlet("/ServletCategoriaJSON")
public class ServletCategoriaJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//
	private DocenteService servicioDocente;
	
    public ServletCategoriaJSON() {
        super();
        servicioDocente=new DocenteService();
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//invocar al mètodo listAllCategoriaService
		List<Categoria> lista=servicioDocente.listAllCategoriaService();
		//crear objeto de la clase Gson
		Gson gson=new Gson();
		//convertir en JSON el valor del arreglo "lista"
		String json=gson.toJson(lista);
		//indicar el tipo de valor a mostrar en el navegador
		response.setContentType("application/json;charset=UTF-8");
		//proceso de imprimir en el navegador
		PrintWriter salida=response.getWriter();
		salida.println(json);
	}

}







