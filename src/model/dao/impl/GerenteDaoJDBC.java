package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseaccess.DB;
import databaseaccess.DbException;
import model.dao.GerenteDao;
import model.entities.Gerente;

public class GerenteDaoJDBC implements GerenteDao{

	private Connection conn;
	
	public GerenteDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Gerente gerente) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO gerentes values (default, ?, ?, ?, ?, ?)");
			ps.setString(1, gerente.getNome());
			ps.setString(2, gerente.getCpf());
			ps.setString(3, gerente.getTelefone());
			ps.setString(4, gerente.getEmail());
			ps.setDate(5, new java.sql.Date(gerente.getData_nascimento().getTime()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public void update(Gerente gerente) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE gerentes SET nome_gerente = ?, cpf_gerente = ?, telefone_gerente = ?, "
					+ "email_gerente = ?, dt_nasciment = ? WHERE id_gerente = ?");
			ps.setString(1, gerente.getNome());
			ps.setString(2, gerente.getCpf());
			ps.setString(3, gerente.getTelefone());
			ps.setString(4, gerente.getEmail());
			ps.setDate(5, new java.sql.Date(gerente.getData_nascimento().getTime()));
			ps.setInt(6, gerente.getId());
			
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
			ps = conn.prepareStatement("DELETE FROM gerentes WHERE id_gerente = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Gerente findById(Integer id) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM gerentes WHERE id_gerente = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				Gerente gerente = new Gerente();
				gerente.setId(rs.getInt("id_gerente"));
				gerente.setNome(rs.getString("nome_gerente"));
				gerente.setCpf(rs.getString("cpf_gerente"));
				gerente.setTelefone(rs.getString("telefone_gerente"));
				gerente.setEmail(rs.getString("email_gerente"));
				gerente.setData_nascimento(rs.getDate("dt_nasciment"));
				
				return gerente;
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
	public List<Gerente> findAll() {

		List<Gerente> lista = new ArrayList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT * FROM gerentes");
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Gerente gerente = new Gerente();
				gerente.setId(rs.getInt("id_gerente"));
				gerente.setNome(rs.getString("nome_gerente"));
				gerente.setCpf(rs.getString("cpf_gerente"));
				gerente.setTelefone(rs.getString("telefone_gerente"));
				gerente.setEmail(rs.getString("email_gerente"));
				gerente.setData_nascimento(rs.getDate("dt_nasciment"));
				
				lista.add(gerente);
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
