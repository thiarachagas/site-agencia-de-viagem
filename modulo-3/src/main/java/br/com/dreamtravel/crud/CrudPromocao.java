package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Date;

import br.com.dreamtravel.modelo.Destino;
import br.com.dreamtravel.modelo.Promocao;
import br.com.dreamtravel.modelo.Registro;

public class CrudPromocao implements CrudMetodos {
	
	private CrudBase crudFilho = new CrudBase(new CrudDestino());

	@Override
	public PreparedStatement geraInsert(Registro r, Connection conn) throws Exception {
		
		String sql = "INSERT INTO promocao (Nome, Descricao, Data_Inicio, Data_Termino, Desconto, fk_Destino_Id) "+
				"VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Promocao p = (Promocao) r;
		pstm.setString(1, p.getNome());
		pstm.setString(2, p.getDescricao());
		pstm.setDate(3, Date.valueOf(p.getDataInicio()));
		pstm.setDate(4, Date.valueOf(p.getDataTermino()));
		pstm.setDouble(5, p.getDesconto());
		pstm.setInt(6, p.getDestino().getId());
		
		return pstm;
	}

	@Override
	public PreparedStatement geraSelectAll(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM promocao";
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm;
	}

	@Override
	public PreparedStatement geraSelect(Object id, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM promocao WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}
	
	@Override
	public PreparedStatement geraSelectPersonalizado(
			List<String> campos,
			List<Object> valores, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM promocao WHERE ";
		
		for (int i = 0, n = campos.size(); i < n; i++) {
			String separador = i == n - 1 ? "" : " AND ";
			sql += campos.get(i) + " = ? " + separador;
		}
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		for (int i = 0, n = valores.size(); i < n; i++) {
			pstm.setObject(i + 1, valores.get(i));
		}
		
		return pstm;
	}

	@Override
	public PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception {
		
		String sql = "UPDATE promocao SET Nome = ?, Descricao = ?"+
				", Data_Inicio = ?, Data_Termino = ?, Desconto = ?"+
				", fk_Destino_Id = ? WHERE Id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Promocao p = (Promocao) r;
		pstm.setString(1, p.getNome());
		pstm.setString(2, p.getDescricao());
		pstm.setDate(3, Date.valueOf(p.getDataInicio()));
		pstm.setDate(4, Date.valueOf(p.getDataTermino()));
		pstm.setDouble(5, p.getDesconto());
		pstm.setInt(6, p.getDestino().getId());
		pstm.setInt(7, p.getId());
		
		return pstm;
	}

	@Override
	public PreparedStatement geraDelete(Object id, Connection conn) throws Exception {
		
		String sql = "DELETE FROM promocao WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public Registro criaRegistro(ResultSet rs, Connection conn) throws Exception {
		
		Promocao p = new Promocao();
		p.setId(rs.getInt("Id"));
		p.setNome(rs.getString("Nome"));
		p.setDescricao(rs.getString("Descricao"));
		p.setDataInicio(rs.getDate("Data_Inicio").toLocalDate());
		p.setDataTermino(rs.getDate("Data_Termino").toLocalDate());
		p.setDesconto(rs.getDouble("Desconto"));

		Destino d = (Destino) crudFilho.busca(rs.getInt("fk_Destino_Id"));
		p.setDestino(d);
		
		return p;
	}

}
