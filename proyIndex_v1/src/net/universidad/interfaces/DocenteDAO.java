package net.universidad.interfaces;

import java.util.List;

import net.universidad.entidad.Docente;

public interface DocenteDAO {
	public List<Docente> listAll();
	public int save(Docente bean);
	public int delete(int cod);
	public int update(Docente bean);
}
