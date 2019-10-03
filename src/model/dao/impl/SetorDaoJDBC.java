package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.SetorDao;
import model.entities.Setor;

public class SetorDaoJDBC implements SetorDao{

	private Connection conn;
	
	public SetorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Setor setor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Setor setor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Setor findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Setor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
