package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.dreamtravel.modelo.Destino;
import br.com.dreamtravel.modelo.Registro;

public class CrudDestino implements CrudMetodos {

	@Override
	public PreparedStatement geraInsert(Registro r, Connection conn) throws Exception {

		String sql = "INSERT INTO destino (Nome, Localizacao, Preco_Medio) "+
				"VALUES (?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Destino d = (Destino) r;
		pstm.setString(1, d.getNome());
		pstm.setString(2, d.getLocalizacao());
		pstm.setDouble(3, d.getPrecoMedio());
		
		return pstm;
	}

	@Override
	public PreparedStatement geraSelectAll(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM destino";
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm;
	}

	@Override
	public PreparedStatement geraSelect(Object id, Connection conn) throws Exception {

		String sql = "SELECT * FROM destino WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception {

		String sql = "UPDATE destino SET Nome = ?, Localizacao = ? "+
				", Preco_Medio = ? WHERE Id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		Destino d = (Destino) r;
		pstm.setString(1, d.getNome());
		pstm.setString(2, d.getLocalizacao());
		pstm.setDouble(3, d.getPrecoMedio());
		pstm.setInt(4, d.getId());
		
		return pstm;
	}

	@Override
	public PreparedStatement geraDelete(Object id, Connection conn) throws Exception {

		String sql = "DELETE FROM destino WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public Registro criaRegistro(ResultSet rs, Connection conn) throws Exception {
		Destino d = new Destino();
		d.setId(rs.getInt("Id"));
		d.setNome(rs.getString("Nome"));
		d.setLocalizacao(rs.getString("Localizacao"));
		d.setPrecoMedio(rs.getDouble("Preco_Medio"));
		return d;
	}

}
