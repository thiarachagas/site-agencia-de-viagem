package br.com.dreamtravel.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.dreamtravel.modelo.Registro;

public interface CrudMetodos {
	
	PreparedStatement geraInsert(Registro r, Connection conn) throws Exception;
	
	PreparedStatement geraSelectAll(Connection conn) throws Exception;
	
	PreparedStatement geraSelect(Object id, Connection conn) throws Exception;
	
	default PreparedStatement geraSelectPersonalizado(
			List<String> campos, 
			List<Object> valores, 
			Connection conn) throws Exception {
		throw new Exception("Metodo nao implementado");
	}
	
	PreparedStatement geraUpdate(Registro r, Connection conn) throws Exception;
	
	PreparedStatement geraDelete(Object id, Connection conn) throws Exception;
	
	Registro criaRegistro(ResultSet rs, Connection conn) throws Exception;
	
}
