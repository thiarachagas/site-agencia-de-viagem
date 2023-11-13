package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMysql;
import modelos.Destino;

	public class DestinoDAO {

		Connection conn = null;
		PreparedStatement pstm = null;


		public void save(Destino destino) {

			String sql = "insert into destino (Preço_Medio, Qtd, Nome_Destino, Localização) values (?,?,?,?,?)";
				
			try {

				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				pstm.setFloat(1, (float) destino.getPrecoMedio());
				pstm.setInt(2, destino.getQtd());
				pstm.setString(3, destino.getNomeDestino());
				pstm.setString(4, destino.getLocalizacao());
				
				
				pstm.execute();
				System.out.println("Destino adicionado com sucesso!");

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

			String sql = "delete * from destino where Id_Destino = ?";

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1, id);
			
				pstm.execute();
				System.out.println("Destino excluído com sucesso!");

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


		public void update(Destino destino) {
			
			String sql = "Update destino set Preço_Destino = ?, Qtd = ?, Nome_Destino = ?"
					+ " Localização = ?" + " where Id_Destino = ?";

			try {

				conn = ConnectionMysql.createConnectionMysql();



				pstm = conn.prepareStatement(sql);
				
				pstm.setFloat(1, (float) destino.getPrecoMedio());
				pstm.setInt(2, destino.getQtd());
				pstm.setString(3, destino.getNomeDestino());
				pstm.setString(4, destino.getLocalizacao());
				
	

//  BUSCAR O CADASTRO
				pstm.setInt(5, destino.getIdDestino());
				

				pstm.execute();
				System.out.println("Destino atualizado com sucesso!");

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
		

		public List<Destino> getDestinos() {

			String sql = "select * from destino";

			List<Destino> destinos = new ArrayList<Destino>();

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();


				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();


				while (rset.next()) {

					Destino destino = new Destino();

					destino.setPrecoMedio(rset.getFloat("Preço_Medio"));
					destino.setQtd(rset.getInt("Qtd"));
					destino.setNomeDestino(rset.getString("Nome_Destino"));
					destino.setLocalizacao(rset.getString("Localização"));
					
					
					destinos.add(destino);
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

			return destinos;
		}

		
		public Destino getDestinoById(int id) {

			String sql = "select * from destino where Id_Destino = ?";
			Destino destino = new Destino();

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, id);
				rset = pstm.executeQuery();

				rset.next();
				
				destino.setPrecoMedio(rset.getFloat("Preço_Medio"));
				destino.setQtd(rset.getInt("Qtd"));
				destino.setNomeDestino(rset.getString("Nome_Destino"));
				destino.setLocalizacao(rset.getString("Localização"));
				

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
			return destino;
	  
	    }

		
	}
