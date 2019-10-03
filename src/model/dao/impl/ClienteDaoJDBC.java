package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseaccess.DB;
import databaseaccess.DbException;
import model.dao.ClienteDao;
import model.entities.Cliente;

public class ClienteDaoJDBC implements ClienteDao{

	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Cliente cliente) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO clientes "
					+ "VALUES (default, ?, ?, ?, ?)");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getTelefone());
			ps.setDate(4, new java.sql.Date(cliente.getData_nascimento().getTime()));
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public void update(Cliente cliente) {
		
		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE clientes SET nome_cliente = ?, cpf_cliente = ?, "
					+ "telefone_cliente = ?, dt_nascimento_cliente = ? WHERE id_cliente = ?");
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getTelefone());
			ps.setDate(4, new java.sql.Date(cliente.getData_nascimento().getTime()));
			ps.setInt(5, cliente.getId());
			
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
			ps = conn.prepareStatement("DELETE FROM clientes WHERE id_cliente = ?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Cliente findById(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM clientes WHERE id_cliente = ?");
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Cliente cliente = new Cliente(); 
				cliente.setId(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome_cliente"));
				cliente.setCpf(rs.getString("cpf_cliente"));
				cliente.setTelefone(rs.getString("telefone_cliente"));
				cliente.setData_nascimento(rs.getDate("dt_nascimento_cliente"));
				return cliente;
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
	public List<Cliente> findAll() {
		
		List<Cliente> lista = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM clientes");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id_cliente"));
				cliente.setNome(rs.getString("nome_cliente"));
				cliente.setCpf(rs.getString("cpf_cliente"));
				cliente.setTelefone(rs.getString("telefone_cliente"));
				cliente.setData_nascimento(rs.getDate("dt_nascimento_cliente"));
				
				lista.add(cliente);
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