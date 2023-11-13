package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMysql;
import modelos.Cliente;

public class ClienteDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

		public void save (Cliente cliente) {


			String sql = "insert into Cliente (CPF_Cliente, Tel_Cliente, Email_Cliente, Nome_Cliente) values (?,?,?,?)";
			
			try {
		//CADASTRO DO CLIENTE		
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, cliente.getCpfCliente());
				pstm.setString(2, cliente.getTelCliente());
				pstm.setString(3, cliente.getEmailCliente());
				pstm.setString(4, cliente.getNomeCliente());
				
				pstm.execute();
				System.out.println("Cliente cadastrado com sucesso!");

			} catch (Exception e) {

				e.printStackTrace();
				
			} finally {

				try {
					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}

// EXCLUIR CADASTRO
		public void removeByCpf(String cpf) {

			String sql = "DELETE FROM cliente WHERE CPF_Cliente = ?";

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1, cpf);
			
				pstm.execute();
				System.out.println("Cliente excluído com sucesso!");

			} catch (Exception e) {

				e.printStackTrace();
				
			} finally {

				try {
					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}

		
		//UPDATE CADASTRO
		public void update(Cliente cliente) {
			
			String sql = "UPDATE cliente SET CPF_Cliente = ?, Tel_Cliente = ?, Email_CLI = ?, Nome_Cliente= ?";

			try {

				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, cliente.getCpfCliente());
				pstm.setString(2, cliente.getTelCliente());
				pstm.setString(3, cliente.getEmailCliente());
				pstm.setString(4, cliente.getNomeCliente());
				

// BUSCA DO CADASTRO
				pstm.setString(1, cliente.getCpfCliente());
				
				pstm.execute();
				System.out.println("Cliente atualizado com sucesso!");

			} catch (Exception e) {

				e.printStackTrace();
			} finally {


				try {
					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		}
		

		public List<Cliente> getClientes() {

			String sql = "SELECT * FROM cliente";

			List<Cliente> clientes = new ArrayList<Cliente>();

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {

					Cliente cliente = new Cliente();

					cliente.setCpfCliente(rset.getString("CPF_Cliente"));

					cliente.setNomeCliente(rset.getString("NOME_Cliente"));

					cliente.setEmailCliente(rset.getString("EMAIL_Cliente"));
					
					cliente.setTelCliente(rset.getString("TEL_Cliente"));

					
					clientes.add(cliente);
				}
			} catch (Exception e) {

				e.printStackTrace();
			} finally {

				try {

					if (rset != null) {

						rset.close();
					}

					if (pstm != null) {

						pstm.close();
					}

					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
			}

			return clientes;
		}

		
		public Cliente getClienteByCpf(String cpf) {

			String sql = "SELECT * FROM cliente where CPF_Cliente = ?";
			Cliente cliente = new Cliente();

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1, cpf);
				rset = pstm.executeQuery();

				rset.next();

				cliente.setNomeCliente(rset.getString("NOME_Cliente"));
				cliente.setEmailCliente(rset.getString("EMAIL_Cliente"));
		
				cliente.setTelCliente(rset.getString("TEL_Cliente"));
				

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rset != null) {
						rset.close();
					}
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return cliente;
	  
	    }
		
		
	}



