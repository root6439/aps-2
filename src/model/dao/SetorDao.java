package model.dao;

import java.util.List;

import model.entities.Setor;

public interface SetorDao {

	void insert(Setor setor);
	void update(Setor setor);
	void deleteById(Integer id);
	Setor findById(Integer id);
	List<Setor> findAll();
	
}
