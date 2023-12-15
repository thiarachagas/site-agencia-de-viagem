package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.dreamtravel.modelo.CompanhiaAerea;
import br.com.dreamtravel.modelo.Destino;
import br.com.dreamtravel.modelo.Passagem;
import br.com.dreamtravel.modelo.Promocao;
import br.com.dreamtravel.modelo.Registro;

public class CrudPassagem implements CrudMetodos {
	
	CrudBase crudDestino = new CrudBase(new CrudDestino());
	CrudBase crudPromocao = new CrudBase(new CrudPromocao());
	CrudBase crudCompanhiaAerea = new CrudBase(new CrudCompanhiaAerea());

	@Override
	public PreparedStatement geraInsert(Registro r, Connection conn) throws Exception {
		
		String sql = "INSERT INTO passagem (Origem, Data_Partida "+
				", fk_Destino_Id, fk_Promocao_Id, fk_Companhia_Aerea_Id) "+
				"VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Passagem p = (Passagem) r;
		pstm.setString(1, p.getOrigem());
		pstm.setDate(2, Date.valueOf(p.getDataPartida()));
		pstm.setInt(3, p.getDestino().getId());
		
		Promocao pr = p.getPromocao();
		Integer idPromocao = pr == null ? null : pr.getId();
		pstm.setObject(4, idPromocao);
		
		pstm.setInt(5, p.getCompanhiaAerea().getId());
		
		return pstm;
	}

	@Override
	public PreparedStatement geraSelectAll(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM passagem";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		return pstm;
	}

	@Override
	public PreparedStatement geraSelect(Object id, Connection conn) throws Exception {

		String sql = "SELECT * FROM passagem WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception {
		
		String sql = "UPDATE passagem SET Origem = ?, Data_Partida = ? "+
				", fk_Destino_Id = ?, fk_Promocao_Id = ?"+
				", fk_Companhia_Aerea_Id = ? WHERE Id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Passagem p = (Passagem) r;
		pstm.setString(1, p.getOrigem());
		pstm.setDate(2, Date.valueOf(p.getDataPartida()));
		pstm.setInt(3, p.getDestino().getId());
		
		Promocao pr = p.getPromocao();
		Integer idPromocao = pr == null ? null : pr.getId();
		pstm.setObject(4, idPromocao);
		
		pstm.setInt(5, p.getCompanhiaAerea().getId());
		pstm.setInt(6, p.getId());
		
		return pstm;
	}

	@Override
	public PreparedStatement geraDelete(Object id, Connection conn) throws Exception {
		
		String sql = "DELETE FROM passagem WHERE id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}
	
	@Override
	public Registro criaRegistro(ResultSet rs, Connection conn) throws Exception {

		Passagem p = new Passagem();
		p.setId(rs.getInt("Id"));
		p.setOrigem(rs.getString("Origem"));
		p.setDataPartida(rs.getDate("Data_Partida").toLocalDate());
		
		Destino d = (Destino) crudDestino.busca(rs.getInt("fk_Destino_Id"));
		p.setDestino(d);
		
		Integer idPromocao = rs.getInt("fk_Promocao_Id");
		Promocao pr = idPromocao == null ? null : (Promocao) crudPromocao.busca(idPromocao);
		p.setPromocao(pr);
		
		CompanhiaAerea c = (CompanhiaAerea) crudCompanhiaAerea.busca(
				rs.getInt("fk_Companhia_Aerea_Id"));
		
		p.setCompanhiaAerea(c);
		
		return p;
	}

}
