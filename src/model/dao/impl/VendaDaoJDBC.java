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
			ps.setInt(1, venda.getId_cliente());
			ps.setInt(2, venda.getId_produto());
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
			ps.setInt(1, venda.getId_cliente());
			ps.setInt(2, venda.getId_produto());
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
			ps = conn.prepareStatement("SELECT * FROM vendas WHERE id_venda = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Venda venda = new Venda();
				venda.setId(rs.getInt("id_venda"));
				venda.setId_cliente(rs.getInt("id_cliente"));
				venda.setId_produto(rs.getInt("id_produto"));
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
			ps = conn.prepareStatement("SELECT * FROM vendas");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Venda venda = new Venda();
				venda.setId(rs.getInt("id_venda"));
				venda.setId_cliente(rs.getInt("id_cliente"));
				venda.setId_produto(rs.getInt("id_produto"));
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