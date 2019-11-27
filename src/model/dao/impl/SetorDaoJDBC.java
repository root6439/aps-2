package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import databaseaccess.DB;
import databaseaccess.DbException;
import model.dao.SetorDao;
import model.entities.Gerente;
import model.entities.Setor;

public class SetorDaoJDBC implements SetorDao {

	private Connection conn;

	public SetorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Setor setor) {

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("INSERT INTO setores VALUES (default, ?, ?)");
			ps.setString(1, setor.getNome());
			ps.setInt(2, setor.getGerente_setor().getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}

	}

	@Override
	public void update(Setor setor) {

		PreparedStatement ps = null;

		try {
			ps = conn.prepareStatement("UPDATE setores SET nome_setor = ?, id_gerente = ? WHERE id_setor = ?");
			ps.setString(1, setor.getNome());
			ps.setInt(2, setor.getGerente_setor().getId());
			ps.setInt(3, setor.getId());

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
			ps = conn.prepareStatement("DELETE FROM setores WHERE id_setor = ?");
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public Setor findById(Integer id) {

		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT * FROM setores "
					+ "WHERE id_setor = ?");
			ps.setInt(1, id);

			rs = ps.executeQuery();

			if (rs.next()) {

				Gerente gerente = new Gerente();
				gerente.setId(rs.getInt("id_gerente"));

				Setor setor = new Setor();
				setor.setId(rs.getInt("id_setor"));
				setor.setNome(rs.getString("nome_setor"));
				setor.setGerente_setor(gerente);

				return setor;
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}

		return null;
	}

	@SuppressWarnings("resource")
	@Override
	public List<Setor> findAll() {

		List<Setor> setores = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement("SELECT s.*, g.* FROM setores AS s " + "JOIN gerentes AS g "
					+ "WHERE s.id_gerente = g.id_gerente");

			rs = ps.executeQuery();

			while (rs.next()) {

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

				setores.add(setor);
			}

			ps = conn.prepareStatement("SELECT * FROM setores WHERE id_gerente IS NULL");

			rs = ps.executeQuery();

			while (rs.next()) {

				Gerente gerente = new Gerente();
				gerente.setNome("Null");

				Setor setor = new Setor();
				setor.setId(rs.getInt("id_setor"));
				setor.setNome(rs.getString("nome_setor"));
				setor.setGerente_setor(gerente);

				setores.add(setor);
			}

			return setores;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}
}