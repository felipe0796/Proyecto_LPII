package net.universidad.fabrica;

import javax.print.Doc;

import net.universidad.interfaces.CategoriaDAO;
import net.universidad.interfaces.DocenteDAO;
import net.universidad.interfaces.UsuarioDAO;

public abstract class DAOFactory {
	// los posibles orígenes de datos
    public static final int MYSQL = 1;
    public static final int ORACLE = 4;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 2;
    public static final int XML = 5;
    // Existirá un método get por cada DAO que exista en el sistema
    // Ejemplo:
    //public abstract ArticuloDAO getArticuloDAO();
    // registramos nuestros daos
   public abstract DocenteDAO getDocenteDAO();
   public abstract CategoriaDAO getCategoriaDAO();
   public abstract UsuarioDAO getUsuarioDAO();
    public static DAOFactory getDAOFactory(int whichFactory){
        switch(whichFactory){
       	case MYSQL:
        	   return new MySqlDAOFactory();
        	case SQLSERVER:
        	    return new SqlSeverDAOFactory();
        	case ORACLE:
        	    //return new OracleDAOFactory();
        	/*case DB2:
        	    return new Db2DAOFactory();
        	case SQLSERVER:
        	    return new SQLSERVER();
        	case XML:
        	    return new XmlDAOFactory();*/
        	default:
        	    return null;
        }
     }
}
