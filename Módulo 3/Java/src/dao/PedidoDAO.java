package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMysql;
import modelos.Pedido;

public class PedidoDAO {

	Connection conn = null;
	PreparedStatement pstm = null;

	
	public void save(Pedido pedido) {

		String sql = "insert into Pedido(Data_Compra, Id_Func, CPF_Cliente, Preço_Compra,"
				+ "Forma_Pag) Values(?,?,?,?,?)";

		try {

			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);

			pstm.setDate(1, new Date(pedido.getDataCompra().getTime()));
			pstm.setInt(2, pedido.getIdFunc());
			pstm.setString(3, pedido.getCpfCliente());
			pstm.setFloat(4, (float) pedido.getPrecoCompra());
			pstm.setString(5, pedido.getFormaPagamento());

		
			pstm.execute();
			System.out.println("Pedido Realizado com Sucesso!");

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

	public void removeById(int codigoPedido) {

		String sql = "Delete from pedido where Codigo_Pedido = ?";

		try {
			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1,codigoPedido);
		
			pstm.execute();
			System.out.println("Pedido excluído com sucesso!");

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


	public void update(Pedido pedido) {
		
				
		String sql = "update pedido set Preco_Compra = ?, Forma_Pag = ?, where codigo_Pedido = ?";

		try {

			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);
			
			pstm.setFloat(1, (float) pedido.getPrecoCompra());
			pstm.setString(2, pedido.getFormaPagamento());
			pstm.setInt(3, pedido.getCodigoPedido());
			
			pstm.execute();
			System.out.println("Pedido atualizado com sucesso!");

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
	
	public List<Pedido> getPedidos() {

		String sql = "select * from pedido";

		List<Pedido> pedidos = new ArrayList<Pedido>();

		ResultSet rset = null;

		try {
			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Pedido pedido = new Pedido();
				

				pstm.setDate(1, new Date(pedido.getDataCompra().getTime()));
				pstm.setInt(2, pedido.getIdFunc());
				pstm.setString(3, pedido.getCpfCliente());
				pstm.setFloat(4, (float) pedido.getPrecoCompra());
				pstm.setString(5, pedido.getFormaPagamento());

				
				pedidos.add(pedido);
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

		return pedidos;
	}

	
	public Pedido getPedidoById(int codigoPedido) {

		String sql = "select * from pedido where Codigo_Pedido = ?";
		Pedido pedido = new Pedido();

		ResultSet rset = null;

		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigoPedido);
			rset = pstm.executeQuery();

			rset.next();

			

			pstm.setDate(1, new Date(pedido.getDataCompra().getTime()));
			pstm.setInt(2, pedido.getIdFunc());
			pstm.setString(3, pedido.getCpfCliente());
			pstm.setFloat(4, (float) pedido.getPrecoCompra());
			pstm.setString(5, pedido.getFormaPagamento());


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
		return pedido;
  
    }

	
}