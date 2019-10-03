package model.dao;

import databaseaccess.DB;
import model.dao.impl.ClienteDaoJDBC;
import model.dao.impl.GerenteDaoJDBC;
import model.dao.impl.ProdutoDaoJDBC;
import model.dao.impl.SetorDaoJDBC;
import model.dao.impl.VendaDaoJDBC;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFactory {

	public static ClienteDao createClienteDao() {
		return new ClienteDaoJDBC(DB.getConnection());
	}
	
	public static GerenteDao createGerenteDao() {
		return new GerenteDaoJDBC(DB.getConnection());
	}
	
	public static ProdutoDao createProdutoDao() {
		return new ProdutoDaoJDBC(DB.getConnection());
	}
	
	public static SetorDao createSetorDao() {
		return new SetorDaoJDBC(DB.getConnection());
	}
	
	public static VendaDao createVendaDao() {
		return new VendaDaoJDBC(DB.getConnection());
	}
	
	public static VendedorDao createVendedorDao() {
		return new VendedorDaoJDBC(DB.getConnection());
	}
}
