package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

import br.com.dreamtravel.modelo.Cliente;
import br.com.dreamtravel.modelo.FormaPagamento;
import br.com.dreamtravel.modelo.Passagem;
import br.com.dreamtravel.modelo.Pedido;
import br.com.dreamtravel.modelo.Registro;

public class CrudPedido implements CrudMetodos {
	
	private CrudBase crudPassagem = new CrudBase(new CrudPassagem());
	private CrudBase crudCliente = new CrudBase(new CrudCliente());
	private CrudBase crudFormaPagamento = new CrudBase(new CrudFormaPagamento());
	
	@Override
	public PreparedStatement geraInsert(Registro r, Connection conn) throws Exception {
		
		String sql = "INSERT INTO pedido (Data_Compra, Hora_Compra, Preco_Compra "+
			", fk_Cliente_CPF, fk_Passagem_Id, fk_Forma_Pagamento_Id)"+
			" VALUES (?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Pedido p = (Pedido) r;
		LocalDate data = p.getDataCompra();
		LocalTime hora = p.getHoraCompra();
		pstm.setDate(1, Date.valueOf(data));
		pstm.setTime(2, Time.valueOf(hora));
		pstm.setDouble(3, p.getPrecoCompra());
		pstm.setString(4, p.getCliente().getCpf());
		pstm.setInt(5, p.getPassagem().getId());
		pstm.setInt(6, p.getFormaPagamento().getId());
		return pstm;
	}

	@Override
	public PreparedStatement geraSelectAll(Connection conn) throws Exception {

		String sql = "SELECT * FROM pedido";
		PreparedStatement pstm = conn.prepareStatement(sql);
		return pstm;
	}

	@Override
	public PreparedStatement geraSelect(Object id, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM pedido WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception {
		
		String sql = "UPDATE pedido SET Data_Compra = ?, Hora_Compra = ?"+
				", Preco_Compra = ?, fk_Cliente_CPF = ?, fk_Passagem_Id = ?"+
				", fk_Forma_Pagamento_Id = ? WHERE Id = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Pedido p = (Pedido) r;
		LocalDate data = p.getDataCompra();
		LocalTime hora = p.getHoraCompra();
		pstm.setDate(1, Date.valueOf(data));
		pstm.setTime(2, Time.valueOf(hora));
		pstm.setDouble(3, p.getPrecoCompra());
		pstm.setString(4, p.getCliente().getCpf());
		pstm.setInt(5, p.getPassagem().getId());
		pstm.setInt(6, p.getFormaPagamento().getId());
		pstm.setInt(7, p.getId());
		
		return pstm;
	}

	@Override
	public PreparedStatement geraDelete(Object id, Connection conn) throws Exception {
		
		String sql = "DELETE FROM pedido WHERE Id = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, (Integer) id);
		return pstm;
	}

	@Override
	public Registro criaRegistro(ResultSet rs, Connection conn) throws Exception {
		Pedido p = new Pedido();
		p.setId(rs.getInt("Id"));
		p.setDataCompra(rs.getDate("Data_Compra").toLocalDate());
		p.setHoraCompra(rs.getTime("Hora_Compra").toLocalTime());
		p.setPrecoCompra(rs.getDouble("Preco_Compra"));
		
		Passagem pa = (Passagem) crudPassagem.busca(
				rs.getInt("fk_Passagem_Id")); 
		p.setPassagem(pa);
		
		Cliente c = (Cliente) crudCliente.busca(
				rs.getString("fk_Cliente_CPF"));
		p.setCliente(c);
		
		FormaPagamento f = (FormaPagamento) crudFormaPagamento.busca(
				rs.getInt("fk_Forma_Pagamento_Id"));
		p.setFormaPagamento(f);
		
		return p;
	}

}
