package model.dao;

import java.util.List;

import model.entities.Produto;

public interface ProdutoDao {

	void insert(Produto produto);
	void update(Produto produto);
	void deleteById(Integer id);
	Produto findById(Integer id);
	List<Produto> findAll();
	
}
