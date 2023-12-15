package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import br.com.dreamtravel.connection.ConnectionFactory;
import br.com.dreamtravel.modelo.Registro;

public class CrudBase {
	
	private CrudMetodos crudMetodos;
	
	public CrudBase(CrudMetodos crudMetodos) {
		this.crudMetodos = crudMetodos;
	}
	
	public void insere(Registro registro) {
		
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = crudMetodos.geraInsert(registro, conn);
			pstm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			fecha(conn);
		}
	}
	
	public List<Registro> lista() {
		
		Connection conn = null;
		List<Registro> registros = new ArrayList<>();
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = crudMetodos.geraSelectAll(conn);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				registros.add(crudMetodos.criaRegistro(rs, conn));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			fecha(conn);
		}
		
		return registros;
	}
	
	public Registro busca(Object id) {
		
		Connection conn = null;
		Registro registro = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = crudMetodos.geraSelect(id, conn);
			ResultSet rs = pstm.executeQuery();
			
			if (rs.next()) {
				registro = crudMetodos.criaRegistro(rs, conn);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			fecha(conn);
		}
		
		return registro;
	}
	
	public List<Registro> buscaPersonalizada(List<String> campos, List<Object> valores) {
		
		Connection conn = null;
		List<Registro> registros = new ArrayList<>();
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = crudMetodos.geraSelectPersonalizado(
					campos, valores, conn);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				registros.add(crudMetodos.criaRegistro(rs, conn));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			fecha(conn);
		}
		
		return registros;
	}
	
	public void atualiza(Registro r) {
		
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = crudMetodos.geraUpdate(r, conn);
			pstm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			fecha(conn);
		}
	}
	
	public void exclui(Object id) {
		
		Connection conn = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			PreparedStatement pstm = crudMetodos.geraDelete(id, conn);
			pstm.execute();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			fecha(conn);
		}
	}
	
	private void fecha(Connection conn) {
		
		if (conn == null) {
			return;
		}
		
		try {				
			conn.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
