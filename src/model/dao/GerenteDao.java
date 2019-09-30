package model.dao;

import java.util.List;

import model.entities.Gerente;

public interface GerenteDao {

	void insert(Gerente gerente);
	void update(Gerente gerente);
	void deleteById(Integer id);
	Gerente findById(Integer id);
	List<Gerente> findAll();
	
}
