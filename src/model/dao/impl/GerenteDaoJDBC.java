package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.GerenteDao;
import model.entities.Gerente;

public class GerenteDaoJDBC implements GerenteDao{

	private Connection conn;
	
	public GerenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Gerente gerente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Gerente gerente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Gerente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Gerente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
