package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseaccess.DB;
import databaseaccess.DbException;
import model.dao.VendaDao;
import model.entities.Cliente;
import model.entities.Produto;
import model.entities.Setor;
import model.entities.Venda;

public class VendaDaoJDBC implements VendaDao{

	private Connection conn;
	
	public VendaDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Venda venda) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO vendas VALUES (default, ?, ?, ?, ?)");
			ps.setInt(1, venda.getVenda_cliente().getId());
			ps.setInt(2, venda.getVenda_produto().getId());
			ps.setDate(3, new java.sql.Date(venda.getData_venda().getTime()));
			ps.setInt(4, venda.getNum_itens_vendidos());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public void update(Venda venda) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE vendas SET id_cliente = ?, id_produto = ?, data_venda = ?, num_itens_vendidos = ? "
					+ "WHERE id_venda = ?");
			ps.setInt(1, venda.getVenda_cliente().getId());
			ps.setInt(2, venda.getVenda_produto().getId());
			ps.setDate(3, new java.sql.Date(venda.getData_venda().getTime()));
			ps.setInt(4, venda.getNum_itens_vendidos());
			ps.setInt(5, venda.getId());
			
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
			ps = conn.prepareStatement("DELETE FROM vendas WHERE id_venda = ?");
			ps.setInt(1, id);
			
			ps.execute();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Venda findById(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT v.*, c.*, p.* FROM vendas AS v " + 
					"JOIN clientes AS c " + 
					"JOIN produtos AS p " + 
					"WHERE v.id_cliente = c.id_cliente AND v.id_produto = p.id_produto AND id_venda = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
								
				Setor setor = new Setor();
				
				Produto p = new Produto();
				p.setId(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome_produto"));
				p.setDescricao(rs.getString("descricao"));
				p.setValor(rs.getDouble("valor_produto"));
				p.setProduto_setor(setor);
				
				Cliente cliente = new Cliente(); 
				cliente.setId(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome_cliente"));
				cliente.setCpf(rs.getString("cpf_cliente"));
				cliente.setTelefone(rs.getString("telefone_cliente"));
				cliente.setData_nascimento(rs.getDate("dt_nascimento_cliente"));
				
				Venda venda = new Venda();
				venda.setId(rs.getInt("id_venda"));
				venda.setVenda_cliente(cliente);
				venda.setVenda_produto(p);
				venda.setData_venda(rs.getDate("data_venda"));
				venda.setNum_itens_vendidos(rs.getInt("num_itens_vendidos"));
				
				return venda;
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
	public List<Venda> findAll() {

		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Venda> vendas = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement("SELECT v.*, c.*, p.* FROM vendas AS v " + 
					"JOIN clientes AS c " + 
					"JOIN produtos AS p " + 
					"WHERE v.id_cliente = c.id_cliente AND v.id_produto = p.id_produto");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Setor setor = new Setor();
				
				Produto p = new Produto();
				p.setId(rs.getInt("id_produto"));
				p.setNome(rs.getString("nome_produto"));
				p.setDescricao(rs.getString("descricao"));
				p.setValor(rs.getDouble("valor_produto"));
				p.setProduto_setor(setor);
				
				Cliente cliente = new Cliente(); 
				cliente.setId(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome_cliente"));
				cliente.setCpf(rs.getString("cpf_cliente"));
				cliente.setTelefone(rs.getString("telefone_cliente"));
				cliente.setData_nascimento(rs.getDate("dt_nascimento_cliente"));
				
				Venda venda = new Venda();
				venda.setId(rs.getInt("id_venda"));
				venda.setVenda_cliente(cliente);
				venda.setVenda_produto(p);
				venda.setData_venda(rs.getDate("data_venda"));
				venda.setNum_itens_vendidos(rs.getInt("num_itens_vendidos"));
				
				vendas.add(venda);
			}
			return vendas;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		} 
	}
}