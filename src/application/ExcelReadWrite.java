package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExcelReadWrite {
	
	private static String STATIC_FILE = "src/files/arquivo.xlsx";
	
	public static void writeExcel(ObservableList<Cliente> clientes) {
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
	}
	
	public static ObservableList<Cliente> readExcel(){
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
	}

}
