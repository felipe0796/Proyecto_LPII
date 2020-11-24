package net.universidad.service;
import java.util.List;

import net.universidad.entidad.Categoria;
import net.universidad.entidad.Docente;
import net.universidad.fabrica.DAOFactory;
import net.universidad.interfaces.CategoriaDAO;
import net.universidad.interfaces.DocenteDAO;

public class DocenteService {
	//1. definir gestor de base de datos
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	//2. definir uno o màs interfaces 
	DocenteDAO daoDocente=fabrica.getDocenteDAO();
	CategoriaDAO daoCategoria=fabrica.getCategoriaDAO();
	
	public List<Docente> listAllService(){
		return daoDocente.listAll();
	}
	
	public int saveService(Docente bean) {
		return daoDocente.save(bean);
	}
	public int deleteService(int cod) {
		return daoDocente.delete(cod);
	}
	public int updateService(Docente bean) {
		return daoDocente.update(bean);
	}
	//
	public List<Categoria> listAllCategoriaService(){
		return daoCategoria.listAll();
	}
	
}


