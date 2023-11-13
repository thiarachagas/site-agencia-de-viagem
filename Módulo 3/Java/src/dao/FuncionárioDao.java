package dao;

    import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;

import connection.ConnectionMysql;
import modelos.Funcionário;

	public class FuncionárioDao{

		Connection conn = null;
		PreparedStatement pstm = null;

		public void save(Funcionário Funcionário) {
			
			String sql = "insert into Funcionário (id_func, nome_func, cargo_func, Salário)" + "values (?,?,?,?)";

			try {

				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1,Funcionário.getIdFunc());
				pstm.setString(2, Funcionário.getNomeFunc());
				pstm.setString(3, Funcionário.getCargoFunc());
				pstm.setFloat(4, (float) Funcionário.getSalario());
				
				pstm.execute();
				System.out.println("Funcionário cadastrado com sucesso!");

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

		public void removeByMat(int id) {

			String sql = "Delete * from Funcionário where id_func = ?";

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				pstm.setInt(1,id);
			
				pstm.execute();
				System.out.println("Funcionário excluído com sucesso!");

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

		public void update(Funcionário Funcionário) {
			
			String sql = " Update Funcionário set Cargo_Func = ? SALARIO_FUNC = ?"
					+ "Id_Func where id_func = ?";

			try {

				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);
				
				pstm.setString(1, Funcionário.getCargoFunc());
				pstm.setFloat(2, (float) Funcionário.getSalario());
				pstm.setInt(3, Funcionário.getIdFunc());

				
// BUSCAR O CADASTRO
				pstm.setInt(4, Funcionário.getIdFunc());
				
				pstm.execute();
				System.out.println("Funcionário atualizado com sucesso!");

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
		
		public List<Funcionário> getFuncionário() {

			String sql = "select * from Funcionário";

			List<Funcionário> Funcionário = new ArrayList<Funcionário>();

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();

				pstm = conn.prepareStatement(sql);

				rset = pstm.executeQuery();

				while (rset.next()) {

					Funcionário funcionário = new Funcionário();

					
					funcionário.setNomeFunc(rset.getString("Nome_Func"));

					funcionário.setCargoFunc(rset.getString("Cargo_Func"));
					
					funcionário.setSalario(rset.getFloat("Salario_Func"));

					funcionário.setIdFunc(rset.getInt("Id_Func"));

									
					Funcionário.add(funcionário);
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

			return Funcionário;
		}

		
		public Funcionário getFuncionárioByIdFunc(int Id) {

			String sql = "select * from Funcionário where id_Func = ?";
			
			Funcionário funcionário = new Funcionário();

			ResultSet rset = null;

			try {
				conn = ConnectionMysql.createConnectionMysql();
				pstm = conn.prepareStatement(sql);
				pstm.setInt(1, Id);
				rset = pstm.executeQuery();

				rset.next();
				
				funcionário.setNomeFunc(rset.getString("Nome_Func"));

				funcionário.setCargoFunc(rset.getString("Cargo_Func"));
				
				funcionário.setSalario(rset.getFloat("Salario_Func"));

				funcionário.setIdFunc(rset.getInt("Id_Func"));
							

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
			return funcionário;
	  
	    }

				
	}
