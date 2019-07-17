package seleniumtraining.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import seleniumtraining.base.Base;

public class Utilities {
	private static Properties properties;
	private static FileReader filereader;
	private static FileInputStream fin;
	private static ArrayList<String> sdata;
	public static Properties readPropertiesFiles(String filename,String filepath) throws IOException {
		try {
			filereader=new FileReader(filepath+"//"+filename+".properties");
			properties=new Properties();
			properties.load(filereader);
		}catch(FileNotFoundException fnf) {
			System.err.println("Properties File Not Found");
			Base.closeWebdriver();
		}
		return properties;
	}
	public static ArrayList<String> readXlsxSheet(String filename,String sheetname,String path) throws IOException{
		File file=new File(path+"\\"+filename+".xls");
		Workbook book=null;
		try {
			fin=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			System.err.print("Properties File Not Found,");
			Base.closeWebdriver();
		}
		String fileextname = null;
		try {
			fileextname=filename.substring(filename.indexOf("."));
			if(fileextname.equalsIgnoreCase(".xls")) {
				book=new HSSFWorkbook(fin);
				HSSFSheet hsheet=(HSSFSheet) book.getSheet(sheetname);
				int rowcount=hsheet.getLastRowNum()-hsheet.getFirstRowNum();
				for(int i=0;i<rowcount;i++) {
					HSSFRow hrow=hsheet.getRow(i);
					for(int j=0;j<hrow.getLastCellNum();j++) {
						sdata.add(hrow.getCell(j).getStringCellValue());
					}
					if(sdata.isEmpty()) {
						System.out.println("Workbook was Empty so data is readed");
					}else {
						System.out.println("Data Read Is Completed");
					}
				}
			}else if(fileextname.equalsIgnoreCase(".xlsx")) {
				System.out.println(".XLSX files are not Supported");
			}
		}catch(StringIndexOutOfBoundsException si) {
			if(si.getMessage().contains("-1")) {
				System.err.println("No Sheet Found");
			}
			//System.out.println(si.getMessage());
		}
		return sdata;
	}
	public static void main(String args[]) throws IOException {
		Utilities.readXlsxSheet("data", "ids", System.getProperty("user.dir")+"//src//main//java//seleniumtraning//properties");
	}
}
