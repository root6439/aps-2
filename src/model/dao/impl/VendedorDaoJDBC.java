package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseaccess.DB;
import databaseaccess.DbException;
import model.dao.VendedorDao;
import model.entities.Gerente;
import model.entities.Setor;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{

	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Vendedor vendedor) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("INSERT INTO vendedores VALUES (default, ?, ?, ?, ?, ?)");
			ps.setInt(1, vendedor.getSetor_vendedor().getId());
			ps.setString(2, vendedor.getNome());
			ps.setString(3, vendedor.getCpf());
			ps.setDate(4, new java.sql.Date(vendedor.getData_nascimento().getTime()));
			ps.setString(5, vendedor.getTelefone());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public void update(Vendedor vendedor) {

		PreparedStatement ps = null;
		
		try {
			ps = conn.prepareStatement("UPDATE vendedores SET id_setor = ?, nome_vendedor = ?, cpf_vendedor = ?, "
					+ "dt_nascimento_vendedor = ?, telefone_vendedor = ?  WHERE id_vendedor = ?");
			ps.setInt(1, vendedor.getSetor_vendedor().getId());
			ps.setString(2, vendedor.getNome());
			ps.setString(3, vendedor.getCpf());
			ps.setDate(4, new java.sql.Date(vendedor.getData_nascimento().getTime()));
			ps.setString(5, vendedor.getTelefone());
			ps.setInt(6, vendedor.getId());
			
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
			ps = conn.prepareStatement("DELETE FROM vendedores WHERE id_vendedor = ?");
			ps.setInt(1, id);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Vendedor findById(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			ps = conn.prepareStatement("SELECT v.*, s.*, g.* FROM vendedores AS v " + 
					"JOIN setores AS s " + 
					"JOIN gerentes AS g " + 
					"WHERE v.id_setor = s.id_setor AND s.id_gerente = g.id_gerente AND id_vendedor = ?");
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
				
				Setor setor = new Setor();
				setor.setId(rs.getInt("id_setor"));
				setor.setNome(rs.getString("nome_setor"));
				setor.setGerente_setor(gerente);
				
				Vendedor vendedor = new Vendedor();
				vendedor.setId(rs.getInt("id_vendedor"));
				vendedor.setNome(rs.getString("nome_vendedor"));
				vendedor.setSetor_vendedor(setor);
				vendedor.setCpf(rs.getString("cpf_vendedor"));
				vendedor.setData_nascimento(rs.getDate("dt_nascimento_vendedor"));
				vendedor.setTelefone(rs.getString("telefone_vendedor"));
				
				return vendedor;
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
	public List<Vendedor> findAll() {

		List<Vendedor> lista = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement("SELECT v.*, s.*, g.* FROM vendedores AS v " + 
					"JOIN setores AS s " + 
					"JOIN gerentes AS g " + 
					"WHERE v.id_setor = s.id_setor AND s.id_gerente = g.id_gerente");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Gerente gerente = new Gerente();
				gerente.setId(rs.getInt("id_gerente"));
				gerente.setNome(rs.getString("nome_gerente"));
				gerente.setCpf(rs.getString("cpf_gerente"));
				gerente.setTelefone(rs.getString("telefone_gerente"));
				gerente.setEmail(rs.getString("email_gerente"));
				gerente.setData_nascimento(rs.getDate("dt_nasciment"));
				
				Setor setor = new Setor();
				setor.setId(rs.getInt("id_setor"));
				setor.setNome(rs.getString("nome_setor"));
				setor.setGerente_setor(gerente);
				
				Vendedor vendedor = new Vendedor();
				vendedor.setId(rs.getInt("id_vendedor"));
				vendedor.setNome(rs.getString("nome_vendedor"));
				vendedor.setSetor_vendedor(setor);
				vendedor.setCpf(rs.getString("cpf_vendedor"));
				vendedor.setData_nascimento(rs.getDate("dt_nascimento_vendedor"));
				vendedor.setTelefone(rs.getString("telefone_vendedor"));
				
				lista.add(vendedor);
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