package application;

import java.sql.Connection;
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
import javafx.scene.control.Button;

public class ApostaDAO {
	
	private Connection conn;
	
	private PreparedStatement ps;
	private ResultSet rs;
	
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

	public Integer getCodigoAposta() {
		System.out.println("getCodigoAposta");
		Integer codigo = 0;
		conn = DBConfig.getConnection();
		String select = "SELECT MAX(codigo) as MAXIMO FROM apostas; ";
		try {
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			while(rs.next()) {
				codigo = rs.getInt(1);
				System.out.println("codigo: "+codigo);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return codigo;
	}

	public ObservableList<ApostaConcurso> getListaDeApostasSalvas(){
		ObservableList<ApostaConcurso> apostas = FXCollections.observableArrayList();
		conn = DBConfig.getConnection();
		String select = " SELECT codigo, data_aposta, d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14, d15 FROM apostas ";
		try {
			ps = conn.prepareStatement(select);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int impPar = 0;
				int soma = 0;
				Integer[] dezenas = new Integer[15];
				List<Integer> listaDezenas = new ArrayList<Integer>();
				listaDezenas.addAll(Arrays.asList(rs.getInt("d1"), 
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
				for(int i : listaDezenas) {
					if(i % 2 != 0)
						impPar++;
					
					soma += i;
				}
				
				for(int i = 0; i < listaDezenas.size(); i++) {
					dezenas[i] = listaDezenas.get(i);
				}
				
				Button action = new Button("---");
				Aposta aposta = new Aposta(rs.getInt("codigo"), impPar, soma, dezenas, action);
				aposta.getAction().setOnAction((evento)->{
					apostas.remove(aposta);
				});
				aposta.getAction().setDisable(true);
				
				System.out.println("Apostas DB aposta: " + aposta);
				
				apostas.add(ApostaConcurso.toApostaConcurso(aposta));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return apostas;
	}
}
