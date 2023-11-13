package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionMysql {
    private static String URL = "jdbc:mysql://localhost:3306/agencia";
    private static String USUARIO = "root";
    private static String SENHA = "";

    public static Connection createConnectionMysql() throws Exception {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	Connection connection = DriverManager.getConnection(URL,USUARIO, SENHA);
          
    	return connection;
    }
      public static void main(String[] args) throws Exception {
	Connection con = createConnectionMysql();
	
	if (con != null){
		System.out.println(con +  "\n\n **** Conexão obtida com sucesso! ****");
		con.close();
		}
      }
    }