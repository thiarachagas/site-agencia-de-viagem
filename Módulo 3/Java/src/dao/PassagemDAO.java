package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMysql;
import modelos.Passagem;

public class PassagemDAO {
	
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save( Passagem passagem) {

		String sql = "insert into Passagem(Destino, Origem, Data_Partida, Preço, CompanhiaAérea, Quantidade) values(Codigo_Pedido)" + " values (?,?,?,?,?,?,?)";

		try {
			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);
			
		    pstm.setString(1, passagem.getDestino());
			pstm.setString(2, passagem.getOrigem());
			pstm.setDate(3,(Date) passagem.getDataPartida());
			pstm.setFloat(4, (float) passagem.getPreco());
			pstm.setString(4,passagem.getCompanhiaAerea());
			pstm.setInt(5, passagem.getQuantidade());
			pstm.setInt(6, passagem.getCodigoPedido());

			
			pstm.execute();
			System.out.println("Passagem cadastrada com sucesso!");

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


	public void removeById(int id) {

		String sql = "Delete from passagem where Id_Passagem = ?";

		try {
			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, id);
		
			pstm.execute();
			System.out.println("Passagem excluída com sucesso!");

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

	public void update(Passagem passagem) {
		
		String sql = "update passagem set Quantidade = ?, Codigo_Pedido = ?"
		+ " where Id_Passagem = ?";

		try {

			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, passagem.getQuantidade());
			pstm.setInt(2, passagem.getCodigoPedido());
			pstm.setInt(3, passagem.getIdPassagem());
			
			pstm.execute();
			System.out.println("Passagem atualizada com sucesso!");

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
	

	public List<Passagem> getPassagens() {

		String sql = "SSelect * from passagem";

		List<Passagem> passagens = new ArrayList<Passagem>();


		ResultSet rset = null;

		try {
			conn = ConnectionMysql.createConnectionMysql();

			pstm = conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				Passagem passagem = new Passagem();

				passagem.setQuantidade(rset.getInt("Quantidade"));

				passagem.setCodigoPedido(rset.getInt("Codigo_Pedido"));

				
				passagens.add(passagem);
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

		return passagens;
	}

	
	public Passagem getPassagemById(int id) {

		String sql = "Select * from passagem where Id_Passagem = ?";
		Passagem passagem = new Passagem();

		ResultSet rset = null;

		try {
			conn = ConnectionMysql.createConnectionMysql();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			rset.next();

			passagem.setQuantidade(rset.getInt("Quantidade"));
			passagem.setIdPassagem(rset.getInt("Id_Passagem"));
	

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
		return passagem;
  
    }


}