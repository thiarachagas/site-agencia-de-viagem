package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.dreamtravel.modelo.Cliente;
import br.com.dreamtravel.modelo.Registro;

public class CrudCliente implements CrudMetodos {

	@Override
	public PreparedStatement geraInsert(Registro r, Connection conn) throws Exception {
		
		String sql = "INSERT INTO cliente (CPF, Email, Tel, Nome, Senha) "+
				"VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		Cliente c = (Cliente) r;
		pstm.setString(1, c.getCpf());
		pstm.setString(2, c.getEmail());
		pstm.setString(3, c.getTel());
		pstm.setString(4, c.getNome());
		pstm.setString(5, c.getSenha());
		
		return pstm;
	}
	
	public PreparedStatement geraSelectAll(Connection conn) throws Exception {
		
		String sql = "SELECT * FROM cliente";
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		return pstm;
	}
	
	public PreparedStatement geraSelect(Object id, Connection conn) throws Exception {
		
		String sql = "SELECT * FROM cliente WHERE CPF = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		String cpf = (String) id;
		pstm.setString(1, cpf);
		
		return pstm;
	}
	
	public PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception {
		
		String sql = "UPDATE cliente SET Email = ?, Tel = ?, Nome = ? "+
				", Senha = ? WHERE CPF = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		Cliente c = (Cliente) r;
		pstm.setString(1, c.getEmail());
		pstm.setString(2, c.getTel());
		pstm.setString(3, c.getNome());
		pstm.setString(4, c.getSenha());
		pstm.setString(5, c.getCpf());
		
		return pstm;
		
	}
	
	public PreparedStatement geraDelete(Object id, Connection conn) throws Exception {
		
		String sql = "DELETE FROM cliente WHERE CPF = ?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		String cpf = (String) id;
		pstm.setString(1, cpf);
		
		return pstm;
	}
	
	public Registro criaRegistro(ResultSet rs, Connection conn) throws Exception {
		
		Cliente cliente = new Cliente();
		cliente.setCpf(rs.getString("CPF"));
		cliente.setEmail(rs.getString("Email"));
		cliente.setTel(rs.getString("Tel"));
		cliente.setNome(rs.getString("Nome"));
		cliente.setSenha(rs.getString("Senha"));
		
		return cliente;
	}

}
