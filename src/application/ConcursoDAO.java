package application;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ConcursoDAO {
	
	private Connection conn;
	
	private PreparedStatement ps;
	private ResultSet rs;
	
	public boolean salvarConcurso(Concurso concurso) {
		boolean salva = false;
		
		conn = DBConfig.getConnection();
		
		String insert = "INSERT INTO concursos(concurso, data_sorteio, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		
		try {
			ps = conn.prepareStatement(insert);
			ps.setInt(1, concurso.getConcurso());
			ps.setDate(2, new Date(concurso.getDataConcurso().getTime())); // A DATA DO REGISTRO DA APOSTA E FEITO PELO DANCO DE DADOS
			ps.setInt(3, concurso.getDezenas().get(0));
			ps.setInt(4, concurso.getDezenas().get(1));
			ps.setInt(5, concurso.getDezenas().get(2));
			ps.setInt(6, concurso.getDezenas().get(3));
			ps.setInt(7, concurso.getDezenas().get(4));
			ps.setInt(8, concurso.getDezenas().get(5));
			ps.setInt(9, concurso.getDezenas().get(6));
			ps.setInt(10, concurso.getDezenas().get(7));
			ps.setInt(11, concurso.getDezenas().get(8));
			ps.setInt(12, concurso.getDezenas().get(9));
			ps.setInt(13, concurso.getDezenas().get(10));
			ps.setInt(14, concurso.getDezenas().get(11));
			ps.setInt(15, concurso.getDezenas().get(12));
			ps.setInt(16, concurso.getDezenas().get(13));
			ps.setInt(17, concurso.getDezenas().get(14));
			
			salva = ps.execute();
			System.out.println("Concurso: "+concurso.getConcurso()+" "+concurso.getDezenas());
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return salva;
	}

	public ObservableList<Concurso> listaDeConcursos(int range){
		ObservableList<Concurso> concursos = FXCollections.observableArrayList();
		
		conn = DBConfig.getConnection();
		String select = "SELECT concurso, data_sorteio. d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15 FROM concursos WHERE concuro = " + maxConcurso() + "";
		
		try {
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				List<Integer> dezenas = new ArrayList<Integer>();
				dezenas.addAll(Arrays.asList(rs.getInt("d1"), 
										       rs.getInt("d2"), 
										       rs.getInt("d3"), 
										       rs.getInt("d4"), 
										       rs.getInt("d5"), 
										       rs.getInt("d6"), 
										       rs.getInt("d7"), 
										       rs.getInt("d8"), 
										       rs.getInt("d9"), 
										       rs.getInt("d10"), 
										       rs.getInt("d11"), 
										       rs.getInt("d12"), 
										       rs.getInt("d13"), 
										       rs.getInt("d14"), 
										       rs.getInt("d15")));
				Concurso c = new Concurso(rs.getInt("concurso"), rs.getDate("data_sorteio"), dezenas);
				concursos.add(c);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return concursos;
	}

	public int maxConcurso() {
		int max = 0;
		conn = DBConfig.getConnection();
		String select = "SELECT MAX(concurso) as MAX FROM concursos ";
		try {
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				max = rs.getInt("MAX");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return max;
	}
}
