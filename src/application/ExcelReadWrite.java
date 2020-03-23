package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExcelReadWrite {
	
	private static String STATIC_FILE = "src/files/arquivo.xlsx";
	
/*public static void writeExcel(ObservableList<Cliente> clientes) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Clientes");
		
		Row row = sheet.createRow(0);
		Cell cellCodigo = row.createCell(0);
		cellCodigo.setCellValue("CODIGO");
		
		Cell cellCliente = row.createCell(1);
		cellCliente.setCellValue("Clientes");
		
		int i = 1;
		for(Cliente c : clientes) {
			row = sheet.createRow(i++);
			
			Cell cellCodigoCliente = row.createCell(0);
			cellCodigoCliente.setCellValue(c.getCodigo());
			
			Cell cellNomeCliente = row.createCell(1);
			cellNomeCliente.setCellValue(c.getNome());
		}
		
		try {
			FileOutputStream outputStream = new FileOutputStream(STATIC_FILE);
			workbook.write(outputStream);
			System.out.println("Excel Write!");
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	public static ObservableList<Concurso> lerArquivoExcelConcursos(String url) {
		ObservableList<Concurso> concursos = FXCollections.observableArrayList();
		
		try {
			FileInputStream fis = new FileInputStream(new File(url));
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			Sheet aba = wb.getSheet("concursos");
			Iterator<Row> interator = aba.iterator();
			//System.out.println(interator.next().getCell(1));
		
			int primeiraLinha = 0;
			
			while (interator.hasNext()) {
				
				Concurso concurso = new Concurso(); //CRIANDO CONCURSOS
				Row row = (Row) interator.next();
				
				if(primeiraLinha == 0) {
					primeiraLinha++ ;
					continue;
				}
		
				Cell cellConcurso = row.getCell(0); //CONCURSO
				concurso.setConcurso((int) cellConcurso.getNumericCellValue());
				
				System.out.println(row.getCell(0).getNumericCellValue());
			/*	
				Cell cellDataConcurso = row.getCell(1); //DATA DO CONCURSO
				concurso.setDataConcurso((cellDataConcurso.getDateCellValue()));
				
				Cell cellD1 = row.getCell(2); // 1º DEZENA
				concurso.setConcurso((int) cellD1.getNumericCellValue());
				Cell cellD2 = row.getCell(3); 
				concurso.setConcurso((int) cellD2.getNumericCellValue());
				Cell cellD3 = row.getCell(4); 
				concurso.setConcurso((int) cellD3.getNumericCellValue());
				Cell cellD4 = row.getCell(5); 
				concurso.setConcurso((int) cellD4.getNumericCellValue());
				Cell cellD5 = row.getCell(6); 
				concurso.setConcurso((int) cellD5.getNumericCellValue());
				Cell cellD6 = row.getCell(7); 
				concurso.setConcurso((int) cellD6.getNumericCellValue());
				Cell cellD7 = row.getCell(8); 
				concurso.setConcurso((int) cellD7.getNumericCellValue());
				Cell cellD8 = row.getCell(9); 
				concurso.setConcurso((int) cellD8.getNumericCellValue());
				Cell cellD9 = row.getCell(10); 
				concurso.setConcurso((int) cellD9.getNumericCellValue());
				Cell cellD10 = row.getCell(11); 
				concurso.setConcurso((int) cellD10.getNumericCellValue());
				Cell cellD11 = row.getCell(12); 
				concurso.setConcurso((int) cellD11.getNumericCellValue());
				Cell cellD12 = row.getCell(13);
				concurso.setConcurso((int) cellD12.getNumericCellValue());
				Cell cellD13 = row.getCell(14); 
				concurso.setConcurso((int) cellD13.getNumericCellValue());
				Cell cellD14 = row.getCell(15); 
				concurso.setConcurso((int) cellD14.getNumericCellValue());
				Cell cellD15 = row.getCell(16); 
				concurso.setConcurso((int) cellD15.getNumericCellValue());
				
				concursos.add(concurso);
			*/
			}
			wb.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return concursos;
	}
	
/*	public static ObservableList<Cliente> readExcel(){
		ObservableList<Cliente> clientes = FXCollections.observableArrayList();
		
		try {
			
			
			FileInputStream inputStream = new FileInputStream(new File(STATIC_FILE));
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			//Sheet sheet = workbook.getSheetAt(0);
			Sheet sheet = workbook.getSheet("Clientes");
			Iterator<Row> iterator = sheet.iterator();
			
			int primeiraLinha = 0;
			
			while (iterator.hasNext()) {
				
				Cliente cliente = new Cliente();
				Row row = iterator.next();
				
				if(primeiraLinha == 0) {
					primeiraLinha++;
					continue;
				}
				
				Cell cellCodigo = row.getCell(0);
				cliente.setCodigo((int) cellCodigo.getNumericCellValue());
				Cell cellCliente = row.getCell(1);
				cliente.setNome(cellCliente.getStringCellValue());
				
				clientes.add(cliente);
						
			}		
			System.out.println("Excel Read!");
			workbook.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}*/

}
