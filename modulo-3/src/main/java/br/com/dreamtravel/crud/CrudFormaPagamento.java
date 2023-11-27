package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.dreamtravel.modelo.FormaPagamento;
import br.com.dreamtravel.modelo.Registro;

public class CrudFormaPagamento implements CrudMetodos {

	@Override
	public PreparedStatement geraInsert(Registro r, Connection conn) throws Exception {
		
		String sql = "INSERT INTO forma_pagamento (Nome) VALUES (?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		FormaPagamento f = (FormaPagamento) r;
		pstm.setString(1, f.getNome());
		return pstm;
	}

	@Override
	public PreparedStatement geraSelectAll(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM forma_pagamento";
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm;
	}

	@Override
	public PreparedStatement geraSelect(Object id, Connection conn) throws Exception {

		String sql = "SELECT * FROM forma_pagamento WHERE id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception {

		String sql = "UPDATE forma_pagamento SET Nome = ? WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		FormaPagamento f = (FormaPagamento) r;
		pstm.setString(1, f.getNome());
		pstm.setInt(2, f.getId());
		return pstm;
	}

	@Override
	public PreparedStatement geraDelete(Object id, Connection conn) throws Exception {

		String sql = "DELETE FROM forma_pagamento WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public Registro criaRegistro(ResultSet rs, Connection conn) throws Exception {

		FormaPagamento f = new FormaPagamento();
		f.setId(rs.getInt("Id"));
		f.setNome(rs.getString("Nome"));
		return f;
	}

}
