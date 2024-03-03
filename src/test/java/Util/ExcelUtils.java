package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ExcelUtils{
	public String filePath;
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook wb;
	XSSFSheet ws;
	XSSFRow row;
	XSSFCell cell;
	
	public static void writeToExcel(List<String> LanguageList,List<String> LevelList,List<String> CourseName,List<String> CourseRating,List<String> CourseDuration) {
		 FileOutputStream file = null;
		 try {
			file=new FileOutputStream(".\\TestOutputData\\CourseDetails.xlsx");
		} 
		 catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
			XSSFWorkbook workbook1=new XSSFWorkbook();
			XSSFSheet sheet1 = workbook1.createSheet("Language");
			XSSFSheet sheet2 = workbook1.createSheet("Level");
			XSSFSheet sheet3 = workbook1.createSheet("CourseDeatils");
			
			XSSFRow r1= sheet1.createRow(0);
			XSSFRow r2= sheet2.createRow(0);
			XSSFRow r3= sheet3.createRow(0);
			
			
			r1.createCell(0).setCellValue("Available Languages");
			r2.createCell(0).setCellValue("Available Levels");
			r3.createCell(0).setCellValue("Course Name");
			r3.createCell(1).setCellValue("Rating");
			r3.createCell(2).setCellValue("Duration");
			
			for(int c=0;c<LanguageList.size();c++) {
				XSSFRow rrr1= sheet1.createRow(c+1);
				rrr1.createCell(0).setCellValue(LanguageList.get(c));
			}
			
			for(int c=0;c<LevelList.size();c++) {
				XSSFRow rr1= sheet2.createRow(c+1);
				rr1.createCell(0).setCellValue(LevelList.get(c));
				}
			
			for(int c=0;c<CourseName.size();c++) {
				XSSFRow rr2= sheet3.createRow(c+1);
				rr2.createCell(0).setCellValue(CourseName.get(c));
				}
			
			for(int c=0;c<CourseRating.size();c++) {
				XSSFRow rr3= sheet3.getRow(c+1);
				rr3.createCell(1).setCellValue(CourseRating.get(c));
				}
			
			for(int c=0;c<CourseDuration.size();c++) {
				XSSFRow rr4= sheet3.getRow(c+1);
				rr4.createCell(2).setCellValue(CourseDuration.get(c));
				}
			
			try {
				workbook1.write(file);
				workbook1.close();
				file.close();
			} 
			catch (IOException e) {
				
				e.printStackTrace();
			}
			

	 }

}