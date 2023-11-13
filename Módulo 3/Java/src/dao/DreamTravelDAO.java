package dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;
	import connection.ConnectionMysql;
	import modelos.DreamTravel;

public class DreamTravelDAO {	
			Connection conn = null;
			PreparedStatement pstm = null;

			
			public void save (DreamTravel DreamTravel) {


				String sql = " insert into DreamTravel (Id_Site,Nome_Fantasma, Endereço, CNPJ, Email, Telefone, Razão_Social) VALUES (?,?,?,?,?,?,?)";
			
				try {

					conn = ConnectionMysql.createConnectionMysql();

					pstm = conn.prepareStatement(sql);
					
					pstm.setInt(1, DreamTravel.getIdSite());
					pstm.setString(2, DreamTravel.getNomeFantasma());
					pstm.setString(3, DreamTravel.getEndereco());
					pstm.setString(4, DreamTravel.getCnpj());
					pstm.setString(5, DreamTravel.getEmail());
					pstm.setString(6, DreamTravel.getTelefone());
					pstm.setString(7, DreamTravel.getRazaoSocial());
					
					pstm.execute();
					System.out.println("Agencia cadastrada com sucesso!");

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


			public void removeByidSite(int IdSite) {

				String sql = "DELETE FROM Agencia WHERE Id_Site = ?";

				try {
					conn = ConnectionMysql.createConnectionMysql();

					pstm = conn.prepareStatement(sql);

					pstm.setInt(1,IdSite);

					pstm.execute();
					System.out.println("Agencia excluída com sucesso!");

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


			public void update(DreamTravel DreamTravel) {
				
				String sql = "UPDATE DreamTravel SET Id_Site = ?, ENDERECO = ?, EMAIL = ?  TELEFONE = ?"
				+ " where Id_Site = ?";

				try {
					
					conn = ConnectionMysql.createConnectionMysql();
					
					pstm = conn.prepareStatement(sql);
					
					
					pstm.setInt(1, DreamTravel.getIdSite());
					pstm.setString(2,DreamTravel.getEndereco());
					pstm.setString(3,DreamTravel.getEmail());
					pstm.setString(4,DreamTravel.getTelefone());
					
				

	//BUSCAR O CADASTRO
					pstm.setInt(1,DreamTravel.getIdSite());
					
					pstm.execute();
					System.out.println("Unidade atualizada com sucesso!");

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
			

			public List<DreamTravel> getDreamTravel() {

				String sql = "select * from DreamTravel";

				List<DreamTravel> DreamTravel = new ArrayList<DreamTravel>();

				ResultSet rset = null;

				try {
					conn = ConnectionMysql.createConnectionMysql();

					pstm = conn.prepareStatement(sql);

					rset = pstm.executeQuery();

					
					while (rset.next()) {

						DreamTravel agencia = new DreamTravel();
						
						
						agencia.setIdSite(rset.getInt("Id_Site"));
						agencia.setTelefone(rset.getString("TELEFONE"));
						agencia.setEmail(rset.getString("EMAIL"));
						agencia.setEndereco(rset.getString("ENDERECO"));

						DreamTravel.add (agencia);
						
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

				return DreamTravel;
			}

			
			public DreamTravel getUnidadesByCod(int IdSite) {

				String sql = " select * from DreamTravel where Id_Site = ?";
				
				DreamTravel agencia = new DreamTravel();

				ResultSet rset = null;

				try {
					conn = ConnectionMysql.createConnectionMysql();
					pstm = conn.prepareStatement(sql);
					pstm.setInt(1, IdSite);
					rset = pstm.executeQuery();

					rset.next();
					
				agencia.setIdSite(rset.getInt("IdSite"));
				agencia.setTelefone(rset.getString("TELEFONE"));
				agencia.setEmail(rset.getString("EMAIL"));
				agencia.setEndereco(rset.getString("ENDERECO"));
					

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
				return agencia;
		  
		    }
				
			
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

