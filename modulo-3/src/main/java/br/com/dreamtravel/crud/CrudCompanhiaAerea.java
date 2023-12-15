package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.dreamtravel.modelo.CompanhiaAerea;
import br.com.dreamtravel.modelo.Registro;

public class CrudCompanhiaAerea implements CrudMetodos {

	@Override
	public PreparedStatement geraInsert(Registro r, Connection conn) throws Exception {
		
		String sql = "INSERT INTO companhia_aerea (Nome) VALUES (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		CompanhiaAerea c = (CompanhiaAerea) r;
		pstm.setString(1, c.getNome());
		return pstm;
	}

	@Override
	public PreparedStatement geraSelectAll(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM companhia_aerea";
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm;
	}

	@Override
	public PreparedStatement geraSelect(Object id, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM companhia_aerea WHERE id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception {
		
		String sql = "UPDATE companhia_aerea SET Nome = ? WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		CompanhiaAerea c = (CompanhiaAerea) r;
		pstm.setString(1, c.getNome());
		pstm.setInt(2, c.getId());
		return pstm;
	}

	@Override
	public PreparedStatement geraDelete(Object id, Connection conn) throws Exception {

		String sql = "DELETE FROM companhia_aerea WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public Registro criaRegistro(ResultSet rs, Connection conn) throws Exception {
		
		CompanhiaAerea c = new CompanhiaAerea();
		c.setId(rs.getInt("Id"));
		c.setNome(rs.getString("Nome"));
		return c;
	}

}
