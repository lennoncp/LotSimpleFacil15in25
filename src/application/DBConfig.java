package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	
	private static String user = "e2vgksndzqqm9hbc";
	private static String password = "gwmzv0mqtf4yc6p1";
	//private static String url = "jdbc:mysql://192.168.1.108:3306/caixa?useSSL=false&useTimezone=true&serverTimezone=UTC";
	//private static String url = "jdbc:mysql://g8r9w9tmspbwmsyo.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/rn6zz3jq7iip2b9i?useSSL=false&useTimezone=true&serverTimezone=UTC";
	private static String url = "jdbc:mysql://s554ongw9quh1xjs.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/uuulyu4xuve81qe6?useSSL=false&useTimezone=true&serverTimezone=UTC";

	
	
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			con = DriverManager.getConnection(url, user, password);
			//con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnection() {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
