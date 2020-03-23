package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;

public class ApostaDAO {
	
	private Connection conn;
	
	private PreparedStatement ps;
	
	public boolean salvarAposta(Aposta aposta) {
		boolean salva = false;
		
		conn = DBConfig.getConnection();
		
		String insert = "INSERT INTO apostas(codigo, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		try {
			ps = conn.prepareStatement(insert);
			ps.setInt(1, aposta.getCodigo());
			//ps.setTimestamp(2, null); // A DATA DO REGISTRO DA APOSTA E FEITO PELO DANCO DE DADOS
			ps.setInt(2, aposta.getDezenas()[0]);
			ps.setInt(3, aposta.getDezenas()[1]);
			ps.setInt(4, aposta.getDezenas()[2]);
			ps.setInt(5, aposta.getDezenas()[3]);
			ps.setInt(6, aposta.getDezenas()[4]);
			ps.setInt(7, aposta.getDezenas()[5]);
			ps.setInt(8, aposta.getDezenas()[6]);
			ps.setInt(9, aposta.getDezenas()[7]);
			ps.setInt(10, aposta.getDezenas()[8]);
			ps.setInt(11, aposta.getDezenas()[9]);
			ps.setInt(12, aposta.getDezenas()[10]);
			ps.setInt(13, aposta.getDezenas()[11]);
			ps.setInt(14, aposta.getDezenas()[12]);
			ps.setInt(15, aposta.getDezenas()[13]);
			ps.setInt(16, aposta.getDezenas()[14]);
			
			salva = ps.execute();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salva;
	}

}
