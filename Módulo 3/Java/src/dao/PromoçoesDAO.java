package dao;

	import java.sql.Connection;
    import java.sql.Date;
    import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

    import connection.ConnectionMysql;
    import modelos.Promoçoes; 

	public class PromoçoesDAO {
		
	    Connection conn = null;
	    PreparedStatement pstm = null;

	    public void save(Promoçoes promocao) {
	    	
	    	String sql = "insert into Promoçoes( (Id_Promoções, Descriçao, Destino_Relacionado, Nome_Promoção, Data_Termino, Data_Inicio, Desconto)" + "values (?,?,?,?,?,?,?)";
	        
			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);
				
			    pstm.setString(1, promocao.getIdPromocoes());
				pstm.setString(2, promocao.getDescricao());
				pstm.setString(3, promocao.getDestinoRelacionado());
				pstm.setString(4, promocao.getNomePromocao());
				pstm.setDate(5,(Date) promocao.getDataTermino());
				pstm.setDate(6,(Date) promocao.getDataInicio());
				pstm.setFloat(7,(float) promocao.getDesconto());
			
			pstm.execute();
			System.out.println("Promoção cadastrada com sucesso!");

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

	    public void update(Promoçoes promocao) {
	    	String sql = "update Promoçoes set Nome_Promoçao = ?, Destino_Relacionado = ?"
	    			+ " where Id_Promoçoes = ?";

	    			try {

	    				conn = ConnectionMysql.createConnectionMysql();

	    				pstm = conn.prepareStatement(sql);
	    				
	    				pstm.setString(1, promocao.getNomePromocao());
	    				pstm.setString(2, promocao.getDestinoRelacionado());
	    				pstm.setString(3, promocao.getIdPromocoes());
	    				
	    				pstm.execute();
	    				System.out.println("Promoção atualizada com sucesso!");

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
	    		
	    public void delete(String idPromocao) {
	    	
	    	String sql = "Delete * from promocao where id_Promocao = ?";

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				pstm.setString(1,idPromocao);

				pstm.execute();
				System.out.println("Promoção excluída com sucesso!");

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

	  
	    public List<Promoçoes> getAllPromoções() {
	        List<Promoçoes> promoções = new ArrayList<Promoçoes>();
	        
	        String sql = "select * from Promoções";

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				
				while (rset.next()) {

					Promoçoes promocao = new Promoçoes();
					
					
					promocao.setIdPromocoes(rset.getString("id_Promocao"));
					promocao.setNomePromocao(rset.getString("Nome_Promocao"));
					promocao.setDestinoRelacionado(rset.getString("Destino_Relacionado"));
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
	        return promoções;
	    }

	    public Promoçoes getPromoçoesById(String idPromocao) {
	     
	        String sql = "Select * from promocao where Id_Promocao = ?";
	        
	        Promoçoes promoçao = new Promoçoes();

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();
				pstm = conn.prepareStatement(sql);
				pstm.setString(1,idPromocao);
				rset = pstm.executeQuery();

				rset.next();

				promoçao.setNomePromocao(rset.getString("Nome_Promocao"));
				promoçao.setIdPromocoes(rset.getString("Id_Promocao"));
		

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
			
			return promoçao;
			
	    }

		public void removeById(String idPromoções) {
			// TODO Auto-generated method stub
			
		}

		public static Promoçoes[] getPromoçoes() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	  