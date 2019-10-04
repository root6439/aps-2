package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseaccess.DB;
import databaseaccess.DbException;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class ProdutoDaoJDBC implements ProdutoDao{

	private Connection conn;
	
	public ProdutoDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Produto produto) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO produtos VALUES (default, ?, ?, ?, ?)");
			ps.setInt(1, produto.getId_setor());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setDouble(4, produto.getValor());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public void update(Produto produto) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE produtos SET id_setor = ?, nome_produto = ?, descricao = ?, valor_produto = ? WHERE id_produto = ?");
			ps.setInt(1, produto.getId_setor());
			ps.setString(2, produto.getNome());
			ps.setString(3, produto.getDescricao());
			ps.setDouble(4, produto.getValor());
			ps.setInt(5, produto.getId());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public void deleteById(Integer id) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("DELETE FROM produtos WHERE id_produto = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Produto findById(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM produtos WHERE id_produto = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id_produto"));
				p.setId_setor(rs.getInt("id_setor"));
				p.setNome(rs.getString("nome_produto"));
				p.setDescricao(rs.getString("descricao"));
				p.setValor(rs.getDouble("valor_produto"));
				
				return p;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
		return null;
	}

	@Override
	public List<Produto> findAll() {

		List<Produto> lista = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM produtos");
			rs = ps.executeQuery();
			
			while (rs.next()) {
				Produto p = new Produto();
				p.setId(rs.getInt("id_produto"));
				p.setId_setor(rs.getInt("id_setor"));
				p.setNome(rs.getString("nome_produto"));
				p.setDescricao(rs.getString("descricao"));
				p.setValor(rs.getDouble("valor_produto"));
				
				lista.add(p);
			}
			return lista;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}
}