package model.dao.impl;

import java.sql.Connection;
import java.util.List;

import model.dao.VendaDao;
import model.entities.Venda;

public class VendaDaoJDBC implements VendaDao{

	private Connection conn;
	
	public VendaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Venda venda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Venda venda) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venda findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venda> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
