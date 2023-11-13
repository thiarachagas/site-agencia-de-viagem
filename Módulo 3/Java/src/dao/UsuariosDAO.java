package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMysql;
import modelos.Usuarios;


public class UsuariosDAO {
 
	Connection conn = null;
	PreparedStatement pstm = null;

	public void save(Usuarios Usuario) {

		String sql = "insert into usuario ( NOME, CPF, EMAIL, SENHA) values (?,?,?,?)";

		try {
			
			
			          conn = ConnectionMysql.createConnectionMysql();
						
						pstm = conn.prepareStatement(sql);
						pstm.setString(1, Usuario.getNome());
						pstm.setString(2, Usuario.getCpfCliente());
						pstm.setString(3, Usuario.getEmailUsuario());
						pstm.setString(4, Usuario.getSenhaUsuario());

						pstm.execute();
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

				public void createConnectionMysql() {	
		
	}

				public void removeById(int id) {
					String sql = "DELETE FROM USUARIO WHERE ID = ?";

					try {
						conn = ConnectionMysql.createConnectionMysql();
						
						pstm = conn.prepareStatement(sql);
						pstm.setInt(1, id);
						pstm.execute();
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

				public void update(Usuarios Usuario) {
					String sql = "UPDATE USUARIO SET NOME = ?, CPF = ?, EMAIL = ?, SENHA = ? WHERE ID = ?";

					try {
	
						conn = ConnectionMysql.createConnectionMysql();
						pstm = conn.prepareStatement(sql);

						pstm.setString(1, Usuario.getNome());
						pstm.setString(2, Usuario.getCpfCliente());
						pstm.setString(3, Usuario.getEmailUsuario());
						pstm.setString(4, Usuario.getSenhaUsuario());
						pstm.setInt(5, Usuario.getIdUsuario());

						pstm.execute();
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

				public List<Usuarios> getUsuarios() {
					String sql = "SELECT * FROM USUARIO";
					List<Usuarios> Usuario = new ArrayList<Usuarios>();
					ResultSet rset = null;

					try {
						conn = ConnectionMysql.createConnectionMysql();
						pstm = conn.prepareStatement(sql);
						rset = pstm.executeQuery();

						while (rset.next()) {
							Usuarios usuario = new Usuarios();

							usuario.setIdUsuario(rset.getInt("ID"));
							usuario.setCpfCliente(rset.getString("CPF"));
							usuario.setNome(rset.getString("NOME"));
							usuario.setEmailUsuario(rset.getString("EMAIL"));
							usuario.setSenhaUsuario(rset.getString("SENHA"));

							Usuario.add(usuario);
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

					return Usuario;
				}

				public Usuarios buscarUsuarioPorEmail(String email) {
					String sql = "SELECT * FROM USUARIO WHERE EMAIL = ?";
					Usuarios usuario = new Usuarios(); 
					ResultSet rset = null;

					try {
						conn = ConnectionMysql.createConnectionMysql();
						pstm = conn.prepareStatement(sql);
						pstm.setString(1, email);
						rset = pstm.executeQuery();

						if (rset.next()) {
							usuario.setIdUsuario(rset.getInt("ID"));
							usuario.setCpfCliente(rset.getString("CPF"));
							usuario.setNome(rset.getString("NOME"));
							usuario.setEmailUsuario(rset.getString("EMAIL"));
							usuario.setSenhaUsuario(rset.getString("SENHA"));
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
					return usuario;
				}

				public Usuarios getUsuarioById(int id) {
					String sql = "SELECT * FROM USUARIO where ID = ?";
					Usuarios usuario = new Usuarios();
					ResultSet rset = null;

					try {
						conn = ConnectionMysql.createConnectionMysql();
						pstm = conn.prepareStatement(sql);
						pstm.setInt(1, id);
						rset = pstm.executeQuery();

						if (rset.next()) {
							usuario.setIdUsuario(rset.getInt("ID"));
							usuario.setCpfCliente(rset.getString("CPF"));
							usuario.setNome(rset.getString("NOME"));
							usuario.setEmailUsuario(rset.getString("EMAIL"));
							usuario.setSenhaUsuario(rset.getString("SENHA"));
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
					return usuario;
				}
			}
